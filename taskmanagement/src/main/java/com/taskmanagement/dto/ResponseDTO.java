package com.taskmanagement.dto;

import com.taskmanagement.Priority;
import com.taskmanagement.TaskStatus;

import java.time.LocalDateTime;

public class ResponseDTO {
    private int id;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    private Priority taskPriority;
    private String taskCategory;
    private LocalDateTime taskStartTime;
    private LocalDateTime taskEndTime;

    // Constructors
    public ResponseDTO() {
    }

    public ResponseDTO(int id, String taskName, String taskDescription, TaskStatus taskStatus,
                           Priority taskPriority, String taskCategory,
                           LocalDateTime taskStartTime, LocalDateTime taskEndTime) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
        this.taskCategory = taskCategory;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;

    }
}
