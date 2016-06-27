package com.dianwuyou.service;

import com.dianwuyou.model.Task;
import com.dianwuyou.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hebowei on 16/6/19.
 */
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    public Task findById(int id) {
        return taskRepository.getTaskById(id);
    }

    public List<Task> findByOwnerId(int ownerId) {
        return taskRepository.getByOwnerId(ownerId);
    }

    public List<Task> getPagedTasks(int pageNo, int pageSize) {
        return taskRepository.getPagedTasks(pageNo, pageSize);
    }

    public void saveTask(Task task) {
        taskRepository.saveTask(task);
    }

    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    public void deleteTaskById(int id) {
        taskRepository.deleteTaskById(id);
    }

    public Long getPageCount(int pageSize) {
        return (taskRepository.getTaskCount() - 1) / pageSize + 1;
    }
}
