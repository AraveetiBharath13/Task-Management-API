package com.taskmanagement.dto;

import com.taskmanagement.Priority;
import com.taskmanagement.TaskStatus;
import com.taskmanagement.entity.Task;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;



    public class RequestDTO {

        @NotBlank(message = "Task Name cannot be blank")
        @Size(min = 2, max = 25, message = "Task Name must be between 2 and 25 characters")
        private String taskName;

        @Size(min = 10, max = 125, message = "Task Description must be between 10 and 125 characters")
        private String taskDescription;
        @Enumerated(EnumType.STRING)
        private TaskStatus taskStatus;
        @Enumerated(EnumType.STRING)
        @NotNull(message = "Task Priority must be specified")
        private Priority taskPriority;

        @NotBlank(message = "Task Category cannot be blank")
        @Size(max = 30, message = "Task Category must not exceed 30 characters")
        private String taskCategory;

        @NotNull(message = "Task Start Time is required")
        @FutureOrPresent(message = "Start time must be in the present or future")
        private LocalDateTime taskStartTime;

        @NotNull(message = "Task End Time is required")
        @Future(message = "End time must be in the future")
        private LocalDateTime taskEndTime;

        // Getters and setters


        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public void setTaskDescription(String taskDescription) {
            this.taskDescription = taskDescription;
        }

        public void setTaskStatus(TaskStatus taskStatus) {
            this.taskStatus = taskStatus;
        }

        public void setTaskPriority(Priority taskPriority) {
            this.taskPriority = taskPriority;
        }

        public void setTaskCategory(String taskCategory) {
            this.taskCategory = taskCategory;
        }

        public void setTaskStartTime(LocalDateTime taskStartTime) {
            this.taskStartTime = taskStartTime;
        }

        public void setTaskEndTime(LocalDateTime taskEndTime) {
            this.taskEndTime = taskEndTime;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getTaskDescription() {
            return taskDescription;
        }

        public TaskStatus getTaskStatus() {
            return taskStatus;
        }

        public Priority getTaskPriority() {
            return taskPriority;
        }

        public String getTaskCategory() {
            return taskCategory;
        }

        public LocalDateTime getTaskStartTime() {
            return taskStartTime;
        }

        public LocalDateTime getTaskEndTime() {
            return taskEndTime;
        }

        public static Task DtoToTask(RequestDTO dto){
            Task task = new Task();
            task.setTaskName(dto.getTaskName());
            task.setTaskDescription(dto.getTaskDescription());
            task.setTaskStatus(dto.getTaskStatus());
            task.setTaskPriority(dto.getTaskPriority());
            task.setTaskCategory(dto.getTaskCategory());
            task.setTaskStartTime(dto.getTaskStartTime());
            task.setTaskEndTime(dto.getTaskEndTime());
            return task;

        }
    }

