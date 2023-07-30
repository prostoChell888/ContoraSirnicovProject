package ru.sirniky.back.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.Indicator;

public interface IndicatorRepository extends JpaRepository<Indicator, Long> {
}
