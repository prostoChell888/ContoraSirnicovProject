package ru.sirniky.back.service;

import ru.sirniky.back.entity.test.TestResult;

public interface ResultService {

    TestResult getResult(Long id);

    public void updateResult(Long id, TestResult updated);
}
