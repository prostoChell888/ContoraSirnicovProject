package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEducationalProgramRequest(
        @NotBlank(message = "Educational program name cannot be blank")
        String name,

        @NotNull(message = "Education level ID cannot be null")
        @Min(value = 1, message = "Education level ID must be greater than 0")
        Long studyDirectionId
) {}
