package ru.sirniky.back.config.appRunner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ru.sirniky.back.dto.TeacherWithPasswordDto;
import ru.sirniky.back.service.RoleService;
import ru.sirniky.back.service.TeacherService;

@Component
@RequiredArgsConstructor
public class AppInit implements ApplicationRunner {

    private final TeacherService teacherService;
    private final RoleService roleService;
    private final Environment environment;

    @Override
    public void run(ApplicationArguments args) {
        roleService.initRoles();

        String fullName = environment.getProperty("teacher.fullname");
        String email = environment.getProperty("teacher.email");
        String password = environment.getProperty("teacher.password");
        String rank = environment.getProperty("teacher.rank");

        TeacherWithPasswordDto teacherAdmin = TeacherWithPasswordDto.builder()
                .fullName(fullName)
                .email(email)
                .password(password)
                .rank(rank)
                .build();

        teacherService.createTeacherAdmin(teacherAdmin);
    }

}

