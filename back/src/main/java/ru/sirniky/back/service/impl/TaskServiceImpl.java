package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sirniky.back.dto.TaskDto;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.task.TaskFactory;
import ru.sirniky.back.exeption.TaskException;
import ru.sirniky.back.repositrory.TaskRepository;
import ru.sirniky.back.service.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskFactory taskFactory;

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
