package com.taskmanagement.service;

import com.taskmanagement.entity.Task;
import com.taskmanagement.exception.TaskNotFoundException;
import com.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;


    public Task saveTaskToDB(Task task) {
        if(taskRepo.findByTaskName(task.getTaskName()).isPresent()) {
            return null;
        }
       return taskRepo.save(task);
    }

    public int deleteTask(String taskName){
        if(taskRepo.deleteByTaskName(taskName) ==0){
            throw new TaskNotFoundException("Task not found with name " + taskName);
        }
        return 1;

    }
    public Task updateTask(Task task){
        Task taskInDB = taskRepo.findByTaskName(task.getTaskName()).get();
        if(taskInDB == null){
            throw new TaskNotFoundException("Task not found with id " + task.getTaskName());
        }
        taskInDB.setTaskName(task.getTaskName());
        taskInDB.setTaskDescription(task.getTaskDescription());
        taskInDB.setTaskPriority(task.getTaskPriority());
        taskInDB.setTaskStatus(task.getTaskStatus());
        taskInDB.setTaskStartTime(task.getTaskStartTime());
        taskInDB.setTaskEndTime(task.getTaskEndTime());
        taskInDB.setTaskCategory(task.getTaskCategory());

        return taskRepo.save(taskInDB);
    }

    public Task getTaskByName(String taskName){
        Task taskInDB = taskRepo.findByTaskName(taskName).get();
        if(taskInDB == null){
            throw new TaskNotFoundException("Task not found with name " + taskName);
        }
        return taskInDB;
    }
    public List<Task> getAllTasks(){
        return taskRepo.findAll();
    }
}
