package ru.sirniky.back.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.request.CreateIndicatorRequest;
import ru.sirniky.back.dto.response.IndicatorResponse;
import ru.sirniky.back.entity.Indicator;
import ru.sirniky.back.exeptions.NotFoundException;
import ru.sirniky.back.mappers.IndicatorMapper;
import ru.sirniky.back.repositrores.CompetenciesRepository;
import ru.sirniky.back.repositrores.IndicatorRepository;
import ru.sirniky.back.service.IndicatorService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class IndicatorServiceImpl implements IndicatorService {
    public static final String INDICATOR_NOT_FOUND_WITH_ID = "Indicator not found with ID: ";
    public static final String NOT_FOUND_COMPETENCIES_WITH_ID = "Not found competencies with id";

    private final IndicatorRepository indicatorRepository;
    private final IndicatorMapper indicatorMapper;
    private final CompetenciesRepository competenciesRepository;

    @Override
    public List<IndicatorResponse> getAllIndicators() {
        List<Indicator> educationLevelList = indicatorRepository.findAll();
        return educationLevelList.stream()
                .map(indicatorMapper::toDto)
                .toList();

    }

    @Override
    public IndicatorResponse getIndicatorById(@Min(1) @NotNull Long id) {
        Indicator indicator = indicatorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(INDICATOR_NOT_FOUND_WITH_ID + id));

        return indicatorMapper.toDto(indicator);
    }

    @Override
    @Transactional
    public IndicatorResponse saveIndicator(@Valid CreateIndicatorRequest indicatorRequest) {
        var competencies = competenciesRepository.findById(indicatorRequest.competenciesId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_COMPETENCIES_WITH_ID));

        Indicator indicator = indicatorMapper.toIndicator(indicatorRequest);
        indicator.setCompetenciesId(competencies);
        indicator = indicatorRepository.save(indicator);

        return indicatorMapper.toDto(indicator);
    }

    @Override
    @Transactional
    public IndicatorResponse updateIndicator(@Min(1) @NotNull Long id, @Valid CreateIndicatorRequest indicatorRequest) {
        indicatorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(INDICATOR_NOT_FOUND_WITH_ID + id));

        var competencies = competenciesRepository.findById(indicatorRequest.competenciesId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_COMPETENCIES_WITH_ID));

        Indicator existingIndicator = indicatorMapper.toIndicator(indicatorRequest);
        existingIndicator.setId(id);
        existingIndicator.setCompetenciesId(competencies);
        existingIndicator = indicatorRepository.save(existingIndicator);

        return indicatorMapper.toDto(existingIndicator);
    }

    @Override
    @Transactional
    public void deleteIndicator(@Min(1) @NotNull Long id) {
        indicatorRepository.deleteById(id);
    }
}
