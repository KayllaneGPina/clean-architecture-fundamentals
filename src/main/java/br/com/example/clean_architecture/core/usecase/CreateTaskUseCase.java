package br.com.example.clean_architecture.core.usecase;

import br.com.example.clean_architecture.core.domain.Task;
import br.com.example.clean_architecture.infraestructure.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {

    private final TaskRepository taskRepository;

    public CreateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(Task task) {
        return taskRepository.save(task);
    }

}
