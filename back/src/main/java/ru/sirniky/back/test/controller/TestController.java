package ru.sirniky.back.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sirniky.back.test.entity.test.Test;
import ru.sirniky.back.test.service.TaskService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TaskService taskService;

//    @GetMapping("/all")
//    public Test getAll() {
//
//        Test test = taskService.createTest();
//        return test;
//    }
}
