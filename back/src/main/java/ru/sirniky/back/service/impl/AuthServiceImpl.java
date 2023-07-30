package ru.sirniky.back.service.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.AuthDto;
import ru.sirniky.back.entity.PersonInfo;
import ru.sirniky.back.exeption.EntityNotFound;
import ru.sirniky.back.repositrory.StudentRepository;
import ru.sirniky.back.repositrory.TeacherRepository;
import ru.sirniky.back.service.AuthService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Validated
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public PersonInfo authUser(@Valid AuthDto authDto) {

        Optional<PersonInfo> person = studentRepository.findByEmailAndPassword(authDto.getEmail(), authDto.getPassword());

        return person.orElseGet(() -> teacherRepository.findByEmailAndPassword(authDto.getEmail(), authDto.getPassword())
                .orElseThrow(() -> new EntityNotFound("entity not found")));

    }
}
