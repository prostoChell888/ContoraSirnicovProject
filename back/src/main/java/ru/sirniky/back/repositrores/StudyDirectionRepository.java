package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.StudyDirection;

public interface StudyDirectionRepository extends JpaRepository<StudyDirection, Long> {
}
