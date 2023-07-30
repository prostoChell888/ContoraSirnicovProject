package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sirniky.back.dto.TestDto;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.test.Test;
import ru.sirniky.back.exeption.TaskException;
import ru.sirniky.back.repositrory.TaskRepository;
import ru.sirniky.back.repositrory.TestRepository;
import ru.sirniky.back.service.TestService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TaskRepository taskRepository;
    private final TestRepository testRepository;

    @Transactional
    public void create(TestDto testDto) {
        List<Task> tasks = new ArrayList<>();
        Test test = new Test();
        test.setName(testDto.getName());
        for(Long id : testDto.getTaskIds()){
            Task task = taskRepository.findById(id)
                    .orElseThrow(() -> new TaskException("Задачи с id = " + id + " нет в базе данных"));
            task.getTests().add(test);
            tasks.add(task);
        }
        test.setTasks(tasks);
        testRepository.save(test);
    }

    public List<Test> findAll(){
        return testRepository.findAll();
    }


}
