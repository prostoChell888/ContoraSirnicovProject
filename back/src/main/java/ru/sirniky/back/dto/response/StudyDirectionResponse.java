package ru.sirniky.back.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record StudyDirectionResponse(
        @NotNull(message = "ID cannot be null")
        @Min(value = 1, message = "ID must be greater than 0")
        Long id,

        @NotBlank(message = "Direction code cannot be blank")
        String directionCode,

        @NotBlank(message = "Name of the direction cannot be blank")
        String nameOfDirection,

        @NotBlank(message = "Educational program cannot be blank")
        String educationalProgram,

        @NotNull(message = "Education level ID cannot be null")
        @Min(value = 1, message = "Education level ID must be greater than 0")
        Long educationLevelId
) {}
