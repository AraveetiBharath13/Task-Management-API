package com.taskmanagement.entity;

import com.taskmanagement.Priority;
import com.taskmanagement.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @NotBlank(message="Task Name cannot be blank")
    @Size(min = 2,max = 25,message = "Task Name must be of 2 to 25 Characters")
    private String taskName;
    @Size(min = 10,max = 125,message = "Task Description must be of 10 to 125 Characters")
    private String taskDescription;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;
    private String taskCategory;
    @NotNull(message = "Task Start Time is required")
    @FutureOrPresent(message = "Task Start Time must be in the present or future")
    private LocalDateTime taskStartTime;
    @NotNull(message = "Task Start Time is required")
    @FutureOrPresent(message = "Task End Time must be in the present or future")
    private LocalDateTime taskEndTime;

    public void setId(int id) {
        this.id = id;
    }

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

    public int getId() {
        return id;
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
}
