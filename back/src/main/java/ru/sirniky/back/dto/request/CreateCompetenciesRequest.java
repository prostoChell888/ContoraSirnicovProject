package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record CreateCompetenciesRequest(
        @NotBlank(message = "Category name cannot be blank")
        String categoryName,

        @NotBlank(message = "Competence code cannot be blank")
        String competenceCode,

        @NotBlank(message = "Name of universal competence cannot be blank")
        String nameOfUniversalCompetence,

        @NotNull(message = "Educational program IDs list cannot be null")
        @Min(value = 1, message = "At least one educational program ID must be provided")
        List<Long> educationalProgramIds
) {}
