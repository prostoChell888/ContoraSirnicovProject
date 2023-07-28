package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateDisciplineRequest(
        @NotBlank(message = "Indicator code cannot be blank")
        String indicatorCode,

        @NotNull(message = "Competencies IDs list cannot be null")
        @Min(value = 1, message = "At least one competencies ID must be provided")
        List<Long> competenciesIds
) {}
