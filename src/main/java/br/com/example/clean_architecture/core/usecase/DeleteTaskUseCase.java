package br.com.example.clean_architecture.core.usecase;

import br.com.example.clean_architecture.infraestructure.repository.TaskRepository;


public class DeleteTaskUseCase {

    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void execute(Long id) {
        taskRepository.deleteById(id);
    }
}
