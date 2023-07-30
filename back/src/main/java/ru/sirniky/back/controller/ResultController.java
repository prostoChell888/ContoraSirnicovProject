package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sirniky.back.dto.TaskDto;
import ru.sirniky.back.dto.TestResultDto;
import ru.sirniky.back.entity.test.TestResult;
import ru.sirniky.back.service.ResultService;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class ResultController {

    ResultService resultService;

    @GetMapping("/{id}")
    public TestResult getResult(Long id){
        return resultService.getResult(id);
    }

    @PostMapping("/{id}/update")
    public void updateTask(@PathVariable Long id, @RequestBody TestResult updated) {
        resultService.updateResult(id, updated);
    }

    @PostMapping("/create")
    public void create(TestResultDto testResultDto){
        resultService.checkAnswer(testResultDto);
    }

}
