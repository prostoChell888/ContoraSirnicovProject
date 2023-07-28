package ru.sirniky.back.test.entity.task;

import org.springframework.stereotype.Component;

@Component
public class TaskFactory {

    private static final String COMPLETION_TASK = "CompletionTask";
    private static final String FREE_TEXT_TASK = "FreeTextTask";
    private static final String MATCHING_TASK = "MatchingTask";
    private static final String MULTIPLE_CHOICE_TASK = "MultipleChoiceTask";
    private static final String ORDERING_TASK = "OrderingTask";
    private static final String SINGLE_CHOICE_TASK = "SingleChoiceTask";

    public Task createTask(TaskDto taskDto){
        Task task = null;

        switch(taskDto.getDType()){
            case(COMPLETION_TASK):
                 task =  CompletionTask.builder()
                        .question(taskDto.getQuestion())
                        .answer(taskDto.getAnswer())
                        .build();
                break;
            case(FREE_TEXT_TASK):
                Task task = new FreeTextTask();
                break;
            case(MATCHING_TASK):
                Task task = new MatchingTask();
                break;
            case(MULTIPLE_CHOICE_TASK):
                Task task = new MultipleChoiceTask();
                break;
            case(ORDERING_TASK):
                Task task = new OrderingTask();
                break;
            case(SINGLE_CHOICE_TASK):
                Task task = new SingleChoiceTask();
                break;
        }
        return task;
    }


}
