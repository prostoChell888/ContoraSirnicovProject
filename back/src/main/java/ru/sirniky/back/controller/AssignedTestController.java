package ru.sirniky.back.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.response.AssignedTestResponse;
import ru.sirniky.back.service.AssignedTestService;

import java.util.List;

@RestController
@RequestMapping("/assign/test")
@RequiredArgsConstructor
public class AssignedTestController {
    private final AssignedTestService assignedTestService;

    @GetMapping("/{studentId}")
    public List<AssignedTestResponse> getCompetenciesById(@PathVariable Integer studentId) {
        return assignedTestService.getAllTaskByStudId(studentId);
    }

//    @PostMapping("/student/{studentId}")
//    public AssignedTestResponse createTaskForStudent(AssignedTestRequest assignedTestRequest) {
//        return assignedTestService.createTaskForStudent(studentId);
//    }
//
//
//    @PostMapping("/group/{groupId}")
//    public AssignedTestsResponce createTaskForGroup(AssignedTestRequest assignedTestRequest) {
//        return assignedTestService.createTaskForGroup(studentId);
//    }






}
