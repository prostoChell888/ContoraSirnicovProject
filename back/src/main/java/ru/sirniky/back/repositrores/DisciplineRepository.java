package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
