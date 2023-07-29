package ru.sirniky.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.dto.TaskDto;
import ru.sirniky.back.entity.task.TaskFactory;
import ru.sirniky.back.exeptions.TaskException;
import ru.sirniky.back.repositrores.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskFactory taskFactory;

    public void createTask(TaskDto taskDto) {
        taskFactory.createTask(taskDto);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<Task> findTasksByDtype(String type){
        return taskRepository.findAllByType(type);
    }

    public Task findTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskException("Задачи с id = " + id + " нет в базе данных"));
    }

}
