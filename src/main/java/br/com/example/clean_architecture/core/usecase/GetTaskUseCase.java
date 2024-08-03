package br.com.example.clean_architecture.core.usecase;

import br.com.example.clean_architecture.core.domain.Task;
import br.com.example.clean_architecture.infraestructure.repository.TaskRepository;

import java.util.List;


public class GetTaskUseCase {

    private final TaskRepository taskRepository;

    public GetTaskUseCase(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> execute() {
        return taskRepository.findAll();
    }
}
