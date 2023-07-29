package ru.sirniky.back.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AuthDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
