package com.dianwuyou.web;


import com.dianwuyou.model.Task;
import com.dianwuyou.service.TaskService;
import com.dianwuyou.web.exception.ModelObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
     * 列出所有Task并加入model
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
}
