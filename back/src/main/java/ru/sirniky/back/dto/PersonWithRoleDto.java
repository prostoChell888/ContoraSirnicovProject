package ru.sirniky.back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
public class PersonWithRoleDto extends PersonDto {

    List<String> roles;
}
