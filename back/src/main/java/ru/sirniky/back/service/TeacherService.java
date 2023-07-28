package ru.sirniky.back.service;

import jakarta.validation.Valid;
import ru.sirniky.back.dto.TeacherDto;
import ru.sirniky.back.entity.Teacher;

public interface TeacherService {

    Teacher createTeacherAdmin(@Valid TeacherDto teacher);
}
