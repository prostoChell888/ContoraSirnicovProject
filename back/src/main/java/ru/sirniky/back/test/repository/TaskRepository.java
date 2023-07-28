package ru.sirniky.back.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sirniky.back.test.entity.task.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {

    @Override
    List<Task> findAll();
}
