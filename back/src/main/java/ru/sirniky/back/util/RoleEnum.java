package ru.sirniky.back.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RoleEnum {

    ADMIN("admin"),
    TEACHER("teacher"),
    STUDENT("student"),
    ;

    private final String roleName;
}
