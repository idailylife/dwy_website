package com.dianwuyou.repo;

import com.dianwuyou.model.UserTask;

import java.util.List;

/**
 * Created by hebowei on 16/7/14.
 */
public interface UserTaskRepository {
    UserTask getById(int id);
    void save(UserTask userTask);
    void update(UserTask userTask);
    List<UserTask> getUserTasks(int userId, int page, int itemsPerPage);
}
