package com.dianwuyou.web;


import com.dianwuyou.model.Message;
import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;
import com.dianwuyou.model.UserTask;
import com.dianwuyou.model.json.AjaxResponseBody;
import com.dianwuyou.model.json.TaskClaimRequestBody;
import com.dianwuyou.service.*;
import com.dianwuyou.web.exception.ModelObjectNotFoundException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by hebowei on 16/6/19.
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    final static int TASKS_PER_PAGE = 10;
    final static long PAGE_NUMBER_MAXIMUM = 30;  //最多多少页(分页用)

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @Autowired
    UserTaskService userTaskService;

    @Autowired
    ImageDiskFileService imageDiskFileService;

    @Autowired
    MessagePersistService messagePersistService;

    @Autowired
    MessageService messageService;

    /**
     * 列出最新的任务(任务大厅功能)
     * @param page 页码号,从1开始
     * @param model
     * @return
     */
    @RequestMapping(value = "/all/{page}", method = RequestMethod.GET)
    public String listAll(@PathVariable("page") Integer page, Model model){
        listAllTasks(page - 1, model);
        return "task/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listAll(Model model){
        listAllTasks(0, model);
        return "task/all";
    }

    /**
     * 列出所有Task
     * @param page 页码号,从0开始
     * @param model
     */
    private void listAllTasks(Integer page, Model model){
        List<Task> tasks = taskService.getPagedTasks(page, TASKS_PER_PAGE);
        Long pageCount = taskService.getPageCount(TASKS_PER_PAGE);
        if(pageCount > PAGE_NUMBER_MAXIMUM)
            pageCount = PAGE_NUMBER_MAXIMUM;
        if(tasks.isEmpty() || page < 0){
            throw new ModelObjectNotFoundException("Cannot find such page.");
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("currentPage", page + 1);
    }

    /**
     * 提交新的任务
     * 此POST请求的传入对象是FormData,不是JSON
     * 后端会计算用户账户内的余额是否足够支付费用,不够支付会返回错误码
     * 如果余额足够,会扣减用户的余额
     * @param request
     * @param task
     * @param bindingResult
     * @return
     * @throws IOException
     */
    @ResponseBody
    @Transactional
    @RequestMapping(value = "/create", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponseBody submitNewTask(HttpServletRequest request, @Valid Task task,
                                          BindingResult bindingResult) throws IOException{
        AjaxResponseBody responseBody = new AjaxResponseBody();
        if(bindingResult.hasErrors()){
            responseBody.setState(400);
            responseBody.setMessage("request format error");
            return responseBody;
        }
        User user = userService.getFromSession(request);
        if(user.getType() == User.USERTYPE_WORKER){
            responseBody.setState(403);
            responseBody.setMessage("Task cannot be created by worker");
            return responseBody;
        }

        //Check if the user's balance is enough to pay the fee
        Double commissonToPay = task.getTotalCost(); //佣金单价*数量
        if(user.getBalance() < commissonToPay){
            responseBody.setState(405);
            responseBody.setMessage("Low user balance");
            responseBody.setContent(user.getBalance().toString());
            return responseBody;
        } else {
            user.setBalance(user.getBalance() - commissonToPay);
            user.addScore(2); //商家成功发布任务+2积分
            userService.updateUser(user);   //Update user balance
        }

        //Save task to generate task id
        if(task.getImage() != null)
            task.setImgHref(task.getImage().getOriginalFilename());
        taskService.saveTask(task);

        //Save file
        if(task.getImage() != null){
            imageDiskFileService.saveTaskCreationImage(user, task);
        }

        //Send messages to target workers
        messagePersistService.storeMessagesForNewTask(task);

        responseBody.setState(200);
        responseBody.setContent(user.getBalance().toString());
        return responseBody;
    }

    /**
     * 传入数据,JSON
     * {
     *     taskId: 任务ID,
     *     messageId: 发任务的消息ID,
     *     quantity: 领取数量
     * }
     * 限制:单用户一天接任务不能超过5个
     *
     * 返回状态码(JSON)
     *      200 - 成功
     *      205 - 任务已满员
     *      400 - 输入格式错误
     *      403 - 用户信息校验错误
     *      405 - 用户当天已申领5个任务,超过限制
     * @return
     */
    @ResponseBody
    @Transactional
    @RequestMapping(value = "/claimTask", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public  AjaxResponseBody claimTask(HttpServletRequest request, @Valid TaskClaimRequestBody taskClaimRequestBody,
                                       BindingResult bindingResult){
        AjaxResponseBody responseBody = new AjaxResponseBody();
        if(bindingResult.hasErrors()){
            responseBody.setState(400);
            responseBody.setMessage("Illegal request format");
            return responseBody;
        }
        Message message = messageService.getById(taskClaimRequestBody.getMessageId());
        User user = userService.getFromSession(request);
        Task task = taskService.findById(taskClaimRequestBody.getTaskId());
        JSONObject msgContent = new JSONObject(message.getContent());

        if(userTaskService.getUserTaskCountToday(user.getId()) >= 5){
            responseBody.setState(402);
            responseBody.setMessage("User have already claimed 5 tasks");
            return responseBody;
        }


        if(!message.getReceiverId().equals(user.getId()) || message.getType() != Message.TYPE_NEW_TASK
                || !taskClaimRequestBody.getTaskId().equals(msgContent.getInt("id"))){
            responseBody.setState(403);
            responseBody.setMessage("Cannot verify task invitation message");
            return responseBody;
        }
        if(taskClaimRequestBody.getQuantity() > (task.getPublishedCount() - task.getClaimedCount())){
            //任务已满员
            responseBody.setState(205);
            responseBody.setContent("All tasks have been claimed");
            return responseBody;
        }
        task.setClaimedCount(task.getClaimedCount() + 1);
        taskService.updateTask(task);

        UserTask userTask = new UserTask();
        userTask.setTaskId(task.getId());
        userTask.setTaskOwnerId(task.getOwnerId());
        userTask.setUserId(user.getId());
        userTask.setFinishTimeLimit(task.getGapDuration());
        userTaskService.save(userTask);

        responseBody.setState(200);
        responseBody.setContent(userTask.getId().toString());
        return responseBody;
    }


    @ResponseBody
    @RequestMapping(value = "/testEligible", method = RequestMethod.GET)
    public String testEligible(){
        Task task = taskService.findById(1);
        List<User> users = userService.getEligibleUsersForTask(task);
        return users.toString();
    }

}
