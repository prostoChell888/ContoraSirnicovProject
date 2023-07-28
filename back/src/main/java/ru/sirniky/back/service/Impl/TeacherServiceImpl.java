package ru.sirniky.back.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.TeacherWithPasswordDto;
import ru.sirniky.back.entity.Teacher;
import ru.sirniky.back.mapper.TeacherMapper;
import ru.sirniky.back.repositrory.TeacherRepository;
import ru.sirniky.back.service.RoleService;
import ru.sirniky.back.service.TeacherService;
import ru.sirniky.back.util.RoleEnum;

@Service
@RequiredArgsConstructor
@Validated
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final RoleService roleService;
    private final TeacherMapper teacherMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Teacher createTeacherAdmin(TeacherWithPasswordDto teacher) {

        Teacher teacherAdmin = teacherMapper.toEntity(teacher);
        teacherAdmin.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacherAdmin.addRole(roleService.getRoleByName(RoleEnum.ADMIN));

        return teacherRepository.save(teacherAdmin);
    }
}
