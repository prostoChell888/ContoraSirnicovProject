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
public class StudentWithPasswordDto extends StudentDto {

    @NotBlank(message = "password must be not blank")
    private String password;
}