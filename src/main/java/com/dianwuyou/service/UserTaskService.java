package com.dianwuyou.service;

import com.dianwuyou.model.UserTask;

/**
 * Created by hebowei on 16/7/17.
 */
public interface UserTaskService {
    void save(UserTask userTask);
    void update(UserTask userTask);
    UserTask getById(int id);
    int getUserTaskCountToday(int userId);
}
