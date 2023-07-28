package ru.sirniky.back.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sirniky.back.test.entity.task.Task;
import ru.sirniky.back.test.entity.task.TaskDto;
import ru.sirniky.back.test.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/create")
    public void create(@RequestBody TaskDto task){
        taskService.createTask(task);
    }
}
