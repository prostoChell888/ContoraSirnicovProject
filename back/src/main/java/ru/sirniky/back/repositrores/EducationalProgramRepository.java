package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.EducationalProgram;

public interface EducationalProgramRepository extends JpaRepository<EducationalProgram, Long> {
    // You can define custom query methods here if needed
}
