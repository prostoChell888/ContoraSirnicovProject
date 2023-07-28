package ru.sirniky.back.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
public class TeacherDto extends PersonDto {

    @NotBlank(message = "rank book must be not blank")
    private String rank;
}
