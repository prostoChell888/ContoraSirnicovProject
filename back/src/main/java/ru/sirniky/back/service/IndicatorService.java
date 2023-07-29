package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.request.CreateIndicatorRequest;
import ru.sirniky.back.dto.response.IndicatorResponse;

import java.util.List;

public interface IndicatorService {
    List<IndicatorResponse> getAllIndicators();

    IndicatorResponse getIndicatorById(@Min(1) @NotNull Long id);

    IndicatorResponse saveIndicator(@Valid CreateIndicatorRequest indicatorRequest);

    IndicatorResponse updateIndicator(@Min(1) @NotNull Long id, @Valid CreateIndicatorRequest indicatorRequest);

    void deleteIndicator(@Min(1) @NotNull Long id);
}
