package ru.sirniky.back.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
public class PersonDto {

    private Integer id;

    @NotBlank(message = "fullname must be not blank")
    private String fullName;

    @NotBlank(message = "email must be not blank")
    @Email
    private String email;
}
