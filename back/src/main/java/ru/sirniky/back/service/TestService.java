package ru.sirniky.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.Test;
import ru.sirniky.back.entity.dto.TestDto;
import ru.sirniky.back.exeptions.TaskException;
import ru.sirniky.back.repositrores.TaskRepository;
import ru.sirniky.back.repositrores.TestRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TestRepository testRepository;

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
