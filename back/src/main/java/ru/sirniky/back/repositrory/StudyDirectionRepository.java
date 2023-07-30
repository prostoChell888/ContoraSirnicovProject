package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.StudyDirection;

public interface StudyDirectionRepository extends JpaRepository<StudyDirection, Long> {
}
