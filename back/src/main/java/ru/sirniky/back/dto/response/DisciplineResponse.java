package ru.sirniky.back.dto.response;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record DisciplineResponse(
        @NotNull(message = "ID cannot be null")
        @Min(value = 1, message = "ID must be greater than 0")
        Long id,

        String indicatorCode,

        List<Long> competencies
) {}
