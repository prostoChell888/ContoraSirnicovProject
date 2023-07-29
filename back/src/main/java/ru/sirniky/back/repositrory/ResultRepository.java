package ru.sirniky.back.repositrory;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.test.TestResult;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<TestResult, Long> {

    public Optional<TestResult> findById(Long id);


}
