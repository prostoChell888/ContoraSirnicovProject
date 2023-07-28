package ru.sirniky.back.service;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.entity.Student;

public interface StudentService {

    Student createStudent(@Valid StudentWithPasswordDto studentDto);
}
