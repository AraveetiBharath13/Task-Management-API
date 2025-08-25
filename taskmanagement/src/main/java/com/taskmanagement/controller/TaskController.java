package com.taskmanagement.controller;

import com.taskmanagement.dto.RequestDTO;
import com.taskmanagement.entity.Task;
import com.taskmanagement.service.TaskService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService taskService;

    @PostMapping("/task/save")
    public ResponseEntity<Task> saveTask(@Valid @RequestBody RequestDTO req){
        return  ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTaskToDB(RequestDTO.DtoToTask(req)));
    }

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getAllTasks(){
        return
    }
}
