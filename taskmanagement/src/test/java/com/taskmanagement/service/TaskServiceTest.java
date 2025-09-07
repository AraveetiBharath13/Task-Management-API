package com.taskmanagement.service;


import com.taskmanagement.entity.Task;
import com.taskmanagement.repository.TaskRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepo;

    @Test
    public void saveTaskToDB_Success() {
        Task task = new Task();
        Optional<Task> opional = Optional.of(new Task());
        when(taskRepo.findByTaskName(anyString())).thenReturn(opional);
        when(taskRepo.save(task)).thenReturn(task);
        Assertions.assertSame(task,taskService.saveTaskToDB(task));
    }


}
