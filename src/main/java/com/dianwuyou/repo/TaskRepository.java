package com.dianwuyou.repo;

import com.dianwuyou.model.Task;

import java.util.List;

/**
 * Created by hebowei on 16/6/19.
 */
public interface TaskRepository {
    Task getTaskById(int id);
    List<Task> getByIds(List<Integer> ids);
    List<Task> getByOwnerId(int ownerId);
    List<Task> getPagedTasks(int pageNo, int pageSize); //pageNo starts from 0
    List<Task> getPagedTasks(int pageNo, int pageSize, boolean showFutureTasks);
    void saveTask(Task task);
    void updateTask(Task task);
    void deleteTaskById(int id);
    Long getTaskCount();
}
