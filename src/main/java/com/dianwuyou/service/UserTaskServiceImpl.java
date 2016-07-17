package com.dianwuyou.service;

import com.dianwuyou.model.UserTask;
import com.dianwuyou.repo.UserTaskRepoImpl;
import com.dianwuyou.repo.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hebowei on 16/7/17.
 */
@Service("userTaskService")
public class UserTaskServiceImpl implements UserTaskService{
    @Autowired
    UserTaskRepository userTaskRepository;

    public void save(UserTask userTask) {
        userTaskRepository.save(userTask);
    }

    public void update(UserTask userTask) {
        userTaskRepository.update(userTask);
    }

    public UserTask getById(int id) {
        return userTaskRepository.getById(id);
    }

    public int getUserTaskCountToday(int userId) {
        return userTaskRepository.getUserTaskCountToday(userId);
    }
}
