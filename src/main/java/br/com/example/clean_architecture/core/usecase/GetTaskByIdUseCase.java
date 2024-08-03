package br.com.example.clean_architecture.core.usecase;

import br.com.example.clean_architecture.core.domain.Task;
import br.com.example.clean_architecture.infraestructure.repository.TaskRepository;

import java.util.Optional;

public class GetTaskByIdUseCase {

    private final TaskRepository taskRepository;

    public GetTaskByIdUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> execute(Long id) {
        return taskRepository.findById(id);
    }
}
