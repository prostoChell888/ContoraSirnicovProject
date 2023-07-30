package ru.sirniky.back.service;

import jakarta.validation.Valid;
import ru.sirniky.back.dto.TeacherDto;
import ru.sirniky.back.dto.TeacherWithPasswordDto;
import ru.sirniky.back.entity.Teacher;

public interface TeacherService {

    Teacher createTeacherAdmin(@Valid TeacherWithPasswordDto teacher);

    Teacher createTeacher(@Valid TeacherDto teacher);
}
