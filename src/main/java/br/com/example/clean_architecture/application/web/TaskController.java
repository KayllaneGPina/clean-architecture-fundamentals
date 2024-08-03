package br.com.example.clean_architecture.application.web;

import br.com.example.clean_architecture.application.mapper.TaskMapper;
import br.com.example.clean_architecture.application.service.TaskService;
import br.com.example.clean_architecture.core.domain.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        List<TaskResponse> responses = tasks.stream()
                .map(taskMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(t -> ResponseEntity.ok(taskMapper.toResponse(t)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest taskRequest) {
        Task task = taskMapper.toEntity(taskRequest);
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(taskMapper.toResponse(createdTask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        Task task = taskMapper.toEntity(taskRequest);
        Optional<Task> updatedTask = taskService.updateTask(id, task);
        return updatedTask.map(t -> ResponseEntity.ok(taskMapper.toResponse(t)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
