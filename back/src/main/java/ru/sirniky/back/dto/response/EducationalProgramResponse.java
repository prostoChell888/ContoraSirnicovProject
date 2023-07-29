package ru.sirniky.back.dto.response;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record EducationalProgramResponse(
        @NotNull(message = "ID cannot be null")
        @Min(value = 1, message = "ID must be greater than 0")
        Long id,

        String name,

        Long educationLevelId
) {}
