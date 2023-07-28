package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.StudentDto;
import ru.sirniky.back.entity.Student;

public interface StudentService {

    Student createStudent(@Valid StudentDto studentDto);

    void deleteStudent(@NotNull int id);
}
