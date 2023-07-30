package ru.sirniky.back.entity.task;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.sirniky.back.dto.TaskDto;
import ru.sirniky.back.exeption.BadRequestException;
import ru.sirniky.back.repositrory.TaskRepository;

import java.util.concurrent.BrokenBarrierException;

@Component
@RequiredArgsConstructor
public class TaskFactory {
    private static final String COMPLETION_TASK = "CompletionTask";
    private static final String FREE_TEXT_TASK = "FreeTextTask";
    private static final String MATCHING_TASK = "MatchingTask";
    private static final String MULTIPLE_CHOICE_TASK = "MultipleChoiceTask";
    private static final String ORDERING_TASK = "OrderingTask";
    private static final String SINGLE_CHOICE_TASK = "SingleChoiceTask";


    private final TaskRepository  taskRepository;

    @Transactional
    public void createTask(TaskDto taskDto){

        switch (taskDto.getDType()) {
            case (COMPLETION_TASK) -> createCompleteTask(taskDto);
            case (FREE_TEXT_TASK) -> createFreeTextTask(taskDto);
            case (MATCHING_TASK) -> createMatchingTask(taskDto);
            case (MULTIPLE_CHOICE_TASK) -> createMultipleChooseTask(taskDto);
            case (ORDERING_TASK) -> createOrderingTask(taskDto);
            case (SINGLE_CHOICE_TASK) -> createSingleChooseTask(taskDto);
            //todo при мердже с девом заменить на BadRequestException
            default -> throw new BadRequestException("Тест с типом "
                    + taskDto.getDType() + " не существует");
        }
    }

    private void createSingleChooseTask(TaskDto taskDto) {
        SingleChoiceTask singleChoiceTask = new SingleChoiceTask();
        singleChoiceTask.setAnswer(taskDto.getAnswer());
        singleChoiceTask.setQuestion(taskDto.getQuestion());
        singleChoiceTask.setOptions(taskDto.getOptions());
        singleChoiceTask.setType(SINGLE_CHOICE_TASK);
        taskRepository.save(singleChoiceTask);
    }

    private void createOrderingTask(TaskDto taskDto) {
        OrderingTask orderingTask = new OrderingTask();
        orderingTask.setAnswer(taskDto.getAnswer());
        orderingTask.setQuestion(taskDto.getQuestion());
        orderingTask.setOptions(taskDto.getOptions());
        orderingTask.setType(ORDERING_TASK);
        taskRepository.save(orderingTask);
    }

    private void createMultipleChooseTask(TaskDto taskDto) {
        MultipleChoiceTask multipleChoiceTask = new MultipleChoiceTask();
        multipleChoiceTask.setAnswer(taskDto.getAnswer());
        multipleChoiceTask.setQuestion(taskDto.getQuestion());
        multipleChoiceTask.setOptions(taskDto.getOptions());
        multipleChoiceTask.setType(MULTIPLE_CHOICE_TASK);
        taskRepository.save(multipleChoiceTask);
    }

    private void createMatchingTask(TaskDto taskDto) {
        MatchingTask matchingTask = new MatchingTask();
        matchingTask.setAnswer(taskDto.getAnswer());
        matchingTask.setQuestion(taskDto.getQuestion());
        matchingTask.setOptions(taskDto.getOptions());
        matchingTask.setType(MATCHING_TASK);
        taskRepository.save(matchingTask);
    }

    private void createFreeTextTask(TaskDto taskDto) {
        FreeTextTask freeTextTask = new FreeTextTask();
        freeTextTask.setAnswer(taskDto.getAnswer());
        freeTextTask.setQuestion(taskDto.getQuestion());
        freeTextTask.setType(FREE_TEXT_TASK);
        taskRepository.save(freeTextTask);
    }

    private void createCompleteTask(TaskDto taskDto) {
        CompletionTask completionTask = new CompletionTask();
        completionTask.setAnswer(taskDto.getAnswer());
        completionTask.setQuestion(taskDto.getQuestion());
        completionTask.setType(COMPLETION_TASK);
        taskRepository.save(completionTask);
    }
}
