package ru.sirniky.back.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.test.entity.test.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
