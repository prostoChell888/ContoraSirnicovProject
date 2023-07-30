package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.EducationLevel;

public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {
}
