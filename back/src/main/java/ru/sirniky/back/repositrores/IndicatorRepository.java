package ru.sirniky.back.repositrores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sirniky.back.entity.Indicator;

public interface IndicatorRepository extends JpaRepository<Indicator, Long> {
    // You can define custom query methods here if needed
}
