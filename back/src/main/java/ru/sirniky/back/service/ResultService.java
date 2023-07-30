package ru.sirniky.back.service;

import ru.sirniky.back.dto.TestResultDto;
import ru.sirniky.back.entity.test.TestResult;

public interface ResultService {

    TestResult getResult(Long id);

    void updateResult(Long id, TestResult updated);

    void checkAnswer(TestResultDto testResultDto);
}
