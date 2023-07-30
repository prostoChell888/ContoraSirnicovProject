package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateIndicatorRequest(
        @NotBlank(message = "Indicator code cannot be blank")
        String indicatorCode,

        @NotBlank(message = "Name of the indicator cannot be blank")
        String nameOfIndicator,

        @NotNull(message = "Competencies ID cannot be null")
        @Min(value = 1, message = "Competencies ID must be greater than 0")
        Long competenciesId
) {}
