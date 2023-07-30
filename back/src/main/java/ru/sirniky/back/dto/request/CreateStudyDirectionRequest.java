package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateStudyDirectionRequest(
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
