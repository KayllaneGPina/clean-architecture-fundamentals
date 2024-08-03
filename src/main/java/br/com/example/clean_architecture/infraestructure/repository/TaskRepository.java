package br.com.example.clean_architecture.infraestructure.repository;

import br.com.example.clean_architecture.core.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
