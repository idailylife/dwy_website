package com.dianwuyou.service;

import com.dianwuyou.model.Task;

import java.util.List;

/**
 * Created by hebowei on 16/6/19.
 */
public interface TaskService {
    Task findById(int id);
    List<Task> findByOwnerId(int ownerId);
    List<Task> getPagedTasks(int pageNo, int pageSize);
    void saveTask(Task task);
    void updateTask(Task task);
    void deleteTaskById(int id);
    Long getPageCount(int pageSize);
}
