package com.taskmanagement.service;

import com.taskmanagement.entity.Task;
import com.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository taskRepo;


    public Task saveTaskToDB(Task task) {
       return taskRepo.save(task);
    }

    public void deleteTask(String taskName){

    }
}
