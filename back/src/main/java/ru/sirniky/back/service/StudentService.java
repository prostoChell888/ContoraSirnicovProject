package ru.sirniky.back.service;

import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.entity.Student;

public interface StudentService {

    Student createStudent(StudentWithPasswordDto studentDto);
}
