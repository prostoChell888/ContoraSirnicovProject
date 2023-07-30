package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.AuthDto;
import ru.sirniky.back.dto.PersonWithRoleDto;
import ru.sirniky.back.mapper.PersonMapper;
import ru.sirniky.back.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final PersonMapper personMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PersonWithRoleDto authUser(@RequestBody AuthDto authDto) {
        return personMapper.toWithRoleDto(authService.authUser(authDto));
    }
}
