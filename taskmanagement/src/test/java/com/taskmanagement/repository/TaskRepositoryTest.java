package com.taskmanagement.repository;

import com.taskmanagement.Priority;
import com.taskmanagement.TaskStatus;
import com.taskmanagement.entity.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;
 
    private Task task;
    
    @BeforeEach
    public void setup(){
         task = new Task();
        task.setTaskName("Finish Report");
        task.setTaskDescription("Prepare and submit the quarterly financial report.");
        task.setTaskStatus(TaskStatus.UPCOMING);
        task.setTaskPriority(Priority.HIGH);
        task.setTaskCategory("Work");
        task.setTaskStartTime(LocalDateTime.now().plusHours(1));
        task.setTaskEndTime(LocalDateTime.now().plusDays(2));
        taskRepository.save(task);
    }
    
    @Test
    public void findByName(){
       Assertions.assertEquals(taskRepository.
               findByTaskName(task.getTaskName()).get().getTaskName(),task.getTaskName());
    }
}
