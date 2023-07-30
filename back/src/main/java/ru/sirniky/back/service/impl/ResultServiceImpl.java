package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sirniky.back.dto.TestResultDto;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.test.TestResult;
import ru.sirniky.back.exeption.EntityNotFound;
import ru.sirniky.back.repositrory.ResultRepository;
import ru.sirniky.back.repositrory.TaskRepository;
import ru.sirniky.back.service.ResultService;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    ResultRepository resultRepository;
    TaskRepository taskRepository;

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

    public void checkAnswer(TestResultDto testResultDto){
        TestResult testResult = new TestResult();
        int resultScore = 0;
        for(var answer : testResultDto.getAnswerList()){
            Task task = taskRepository.findById(answer.getQuestionId())
                    .orElseThrow(() -> new EntityNotFound("Вопрос не найден"));
            if(!task.getType().equals("FreeTextTask") && !task.getType().equals("CompletionTask") && task.getAnswer().equals(answer.getAnswer())){
                resultScore++;
            }
        }
        testResult.setScores(resultScore);
        resultRepository.save(testResult);
    }

}
