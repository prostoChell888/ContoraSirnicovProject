package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.EducationalProgram;

public interface EducationalProgramRepository extends JpaRepository<EducationalProgram, Long> {
}
