package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sirniky.back.entity.test.TestResult;
import ru.sirniky.back.exeption.EntityNotFound;
import ru.sirniky.back.repositrory.ResultRepository;
import ru.sirniky.back.service.ResultService;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    ResultRepository resultRepository;

    public TestResult getResult(Long id){
        return resultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Результат с id = " + id + " Не найден" ));
    }

    public void updateResult(Long id, TestResult updated){
        TestResult result = getResult(id);
        result.setScores(updated.getScores());
        result.setStatus(updated.getStatus());
        resultRepository.save(result);
    }

}
