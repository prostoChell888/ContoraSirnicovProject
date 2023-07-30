package ru.sirniky.back.service;

import jakarta.validation.Valid;
import ru.sirniky.back.dto.AuthDto;
import ru.sirniky.back.entity.PersonInfo;

public interface AuthService {

    PersonInfo authUser(@Valid AuthDto authDto);
}
