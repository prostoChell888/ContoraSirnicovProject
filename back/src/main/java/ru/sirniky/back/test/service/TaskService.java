package ru.sirniky.back.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sirniky.back.test.entity.task.Task;
import ru.sirniky.back.test.entity.task.TaskDto;
import ru.sirniky.back.test.entity.task.TaskFactory;
import ru.sirniky.back.test.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskFactory taskFactory;

    public void createTask(TaskDto taskDto) {
        Task task = taskFactory.createTask(taskDto);
        taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
