package br.com.example.clean_architecture.application.service;

import br.com.example.clean_architecture.core.domain.Task;
import br.com.example.clean_architecture.core.usecase.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;

    public TaskService(
            CreateTaskUseCase createTaskUseCase,
            GetTaskByIdUseCase getTaskByIdUseCase,
            GetTaskUseCase getTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase,
            DeleteTaskUseCase deleteTaskUseCase
    ) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.getTaskUseCase = getTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
    }

    public Task createTask(Task task) {
        return createTaskUseCase.execute(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return getTaskByIdUseCase.execute(id);
    }

    public List<Task> getAllTasks() {
        return getTaskUseCase.execute();
    }

    public Optional<Task> updateTask(Long id, Task task) {
        return updateTaskUseCase.execute(id, task);
    }

    public void deleteTask(Long id) {
        deleteTaskUseCase.execute(id);
    }
}
