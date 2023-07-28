package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sirniky.back.entity.Competencies;

@Repository
public interface CompetenciesRepository extends JpaRepository<Competencies, Long> {
}
