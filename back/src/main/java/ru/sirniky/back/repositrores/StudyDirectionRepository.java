package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.StudyDirection;

public interface StudyDirectionRepository extends JpaRepository<StudyDirection, Long> {
    // You can define custom query methods here if needed
}
