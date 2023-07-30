package ru.sirniky.back.service;

import ru.sirniky.back.dto.TaskDto;
import ru.sirniky.back.entity.task.Task;

import java.util.List;

public interface TaskService {

    void createTask(TaskDto taskDto);

    List<Task> findAll();

    List<Task> findTasksByDtype(String type);

    Task findTaskById(Long id);

}
