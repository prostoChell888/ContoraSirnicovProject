package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.Indicator;
import ru.sirniky.back.repositrores.IndicatorRepository;
import jakarta.validation.constraints.NotNull;


import java.util.List;
import java.util.Optional;

@Service
@Validated
public class IndicatorService {
    private final IndicatorRepository indicatorRepository;

    @Autowired
    public IndicatorService(IndicatorRepository indicatorRepository) {
        this.indicatorRepository = indicatorRepository;
    }

    public List<Indicator> getAllIndicators() {
        return indicatorRepository.findAll();
    }

    public Optional<Indicator> getIndicatorById(@Min(1)@NotNull Long id) {
        return indicatorRepository.findById(id);
    }

    public Indicator saveIndicator(@Valid Indicator indicator) {
        return indicatorRepository.save(indicator);
    }

    public Indicator updateIndicator(@Valid Indicator indicator) {
        return indicatorRepository.save(indicator);
    }

    public void deleteIndicator(@Min(1)@NotNull Long id) {
        indicatorRepository.deleteById(id);
    }
}
