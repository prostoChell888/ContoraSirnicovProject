package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.dto.TaskDto;
import ru.sirniky.back.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskServiceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TaskDto task){
        taskServiceImpl.createTask(task);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam(required = false) String type) {
        if (type != null) {
            return taskServiceImpl.findTasksByDtype(type);
        } else {
            return taskServiceImpl.findAll();
        }
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Long id) {
        return taskServiceImpl.findTaskById(id);
    }

//    @PostMapping("/{id}/update")
//    public void updateTask(@PathVariable Long id, @RequestBody TaskDto updatedTask) {
//        taskService.updateTask(id, updatedTask);
//    }
}
