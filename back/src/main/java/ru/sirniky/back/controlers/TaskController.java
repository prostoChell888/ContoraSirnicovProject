package ru.sirniky.back.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sirniky.back.entity.task.Task;
import ru.sirniky.back.entity.dto.TaskDto;
import ru.sirniky.back.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public void create(@RequestBody TaskDto task){
        taskService.createTask(task);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam(required = false) String type) {
        if (type != null) {
            return taskService.findTasksByDtype(type);
        } else {
            return taskService.findAll();
        }
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Long id) {
        return taskService.findTaskById(id);
    }

//    @PostMapping("/{id}/update")
//    public void updateTask(@PathVariable Long id, @RequestBody TaskDto updatedTask) {
//        taskService.updateTask(id, updatedTask);
//    }
}
