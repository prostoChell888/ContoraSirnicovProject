package ru.sirniky.back.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.StudentDto;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.exeption.EntityAlreadyExist;
import ru.sirniky.back.mapper.StudentMapper;
import ru.sirniky.back.repositrory.StudentRepository;
import ru.sirniky.back.service.RoleService;
import ru.sirniky.back.service.StudentService;
import ru.sirniky.back.util.RoleEnum;

@Service
@RequiredArgsConstructor
@Validated
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final RoleService roleService;
    private final StudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;

    private final RandomStringGenerator passwordGenerator;
    private final Environment environment;

    @Override
    @Transactional
    public Student createStudent(StudentDto studentDto) {

        if (studentRepository.findByEmail(studentDto.getEmail()).isPresent()) {
            throw new EntityAlreadyExist("student with email " + studentDto.getEmail() + " already exist");
        }

        Student newStudent = studentMapper.toEntity(studentDto);
        newStudent.setPassword(passwordEncoder.encode(passwordGenerator.generate(environment.getProperty("password.length", Integer.class))));

        newStudent.addRole(roleService.getRoleByName(RoleEnum.STUDENT));

        return studentRepository.save(newStudent);
    }
}
