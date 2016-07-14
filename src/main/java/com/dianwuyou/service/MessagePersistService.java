package com.dianwuyou.service;

import com.dianwuyou.model.Message;
import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hebowei on 16/7/13.
 * Persist message instances asynchronously
 */
@Service
public class MessagePersistService {
    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Autowired
    MessageService messageService;

    /**
     * Find qualified users and send them messages about the new available task
     * @param task
     */
    @Async
    public void storeMessagesForNewTask(Task task){
        List<User> eligibleUsers = userService.getEligibleUsersForTask(task);
        for(User user:eligibleUsers){
            Message message = new Message();
            message.setType(Message.TYPE_NEW_TASK);
            message.setReceiverId(user.getId());
            message.setContent(task.toString());
            messageService.save(message);
        }
    }
}
