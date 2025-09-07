package com.taskmanagement.controller;

import com.taskmanagement.dto.RequestDTO;
import com.taskmanagement.entity.Task;
import com.taskmanagement.service.TaskService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task/save")
    public ResponseEntity<String> saveTask(@Valid @RequestBody RequestDTO req){
        return  taskService.saveTaskToDB(RequestDTO.DtoToTask(req)) !=null?
                ResponseEntity.status(HttpStatus.CREATED).
                        body("Task saved Successfully")
                : ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).
                body("Task Already Exists");
    }

    @GetMapping("/task/getall")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());

    }

    @DeleteMapping("/task/delete")
    public ResponseEntity<String> deleteTask(String taskName){
        return taskService.deleteTask(taskName)==1?ResponseEntity.status(HttpStatus.OK).body("Task " + taskName + " Sucessfully Deleted")
                :ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task " + taskName + " not found");
    }

    @PutMapping("/task/update")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody RequestDTO req){
        return  ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(RequestDTO.DtoToTask(req)));
    }

    @GetMapping("/task/get")
    public ResponseEntity<RequestDTO> getTaskByName(String taskName){
        return ResponseEntity.status(HttpStatus.OK).body(RequestDTO.TaskToDto(taskService.getTaskByName(taskName)));
    }
}
