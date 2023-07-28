package ru.sirniky.back.dto.request;

import jakarta.validation.constraints.NotBlank;


public record CreateEducationLevelRequest(
        @NotBlank(message = "Education level label cannot be blank")
        String label,

        @NotBlank(message = "UGSN code cannot be blank")
        String ugsnCode,

        @NotBlank(message = "UGSN label cannot be blank")
        String ugsnLabel,

        @NotBlank(message = "Direction code cannot be blank")
        String directionCode
) {}
