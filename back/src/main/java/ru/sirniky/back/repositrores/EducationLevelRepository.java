package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.EducationLevel;

public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {
    // You can define custom query methods here if needed
}
