package br.com.example.clean_architecture.core.usecase;

import br.com.example.clean_architecture.core.domain.Task;
import br.com.example.clean_architecture.infraestructure.repository.TaskRepository;

import java.util.Optional;

public class UpdateTaskUseCase {
    private final TaskRepository taskRepository;

    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> execute(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            return taskRepository.save(task);
        });
    }
}
