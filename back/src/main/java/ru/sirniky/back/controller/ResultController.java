package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.TestResultDto;
import ru.sirniky.back.entity.test.TestResult;
import ru.sirniky.back.service.ResultService;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @GetMapping("/{id}")
    public TestResult getResult(Long id){
        return resultService.getResult(id);
    }

    @PutMapping("/{id}/update")
    public void updateTask(@PathVariable Long id, @RequestBody TestResult updated) {
        resultService.updateResult(id, updated);
    }

    @PostMapping("/create")
    public void create(@RequestBody TestResultDto testResultDto){
        resultService.checkAnswer(testResultDto);
    }

}
