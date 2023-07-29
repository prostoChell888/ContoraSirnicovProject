package ru.sirniky.back.service.Impl;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.TeacherDto;
import ru.sirniky.back.dto.TeacherWithPasswordDto;
import ru.sirniky.back.entity.Teacher;
import ru.sirniky.back.exeption.EntityAlreadyExist;
import ru.sirniky.back.mapper.TeacherMapper;
import ru.sirniky.back.repositrory.TeacherRepository;
import ru.sirniky.back.service.RoleService;
import ru.sirniky.back.service.TeacherService;
import ru.sirniky.back.util.RoleEnum;
import ru.sirniky.back.util.password.PasswordGenerator;

@Service
@RequiredArgsConstructor
@Validated
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final RoleService roleService;
    private final TeacherMapper teacherMapper;
    private final PasswordEncoder passwordEncoder;
    private final PasswordGenerator passwordGenerator;

    @Override
    @Transactional
    public Teacher createTeacherAdmin(@Valid TeacherWithPasswordDto teacher) {

        Teacher teacherAdmin = teacherMapper.toEntity(teacher);
        teacherAdmin.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacherAdmin.addRole(roleService.getRoleByName(RoleEnum.ADMIN));
        teacherAdmin.addRole(roleService.getRoleByName(RoleEnum.TEACHER));

        return teacherRepository.save(teacherAdmin);
    }

    @Override
    @Transactional
    public Teacher createTeacher(TeacherDto teacher) {

        if (teacherRepository.findByEmail(teacher.getEmail()).isPresent()) {
            throw new EntityAlreadyExist("student with email " + teacher.getEmail() + " already exist");
        }

        Teacher newTeacher = teacherMapper.toEntity(teacher);
        newTeacher.setPassword(passwordEncoder.encode(passwordGenerator.generate()));
        newTeacher.addRole(roleService.getRoleByName(RoleEnum.TEACHER));

        return teacherRepository.save(newTeacher);
    }
}
