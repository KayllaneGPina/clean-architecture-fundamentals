package br.com.example.clean_architecture.application.mapper;

import br.com.example.clean_architecture.application.web.TaskRequest;
import br.com.example.clean_architecture.application.web.TaskResponse;
import br.com.example.clean_architecture.core.domain.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task toEntity(TaskRequest request) {
        return new Task(null, request.title(), request.description(), request.status());
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
    }
}
