package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import ru.sirniky.back.dto.StudentDto;
import ru.sirniky.back.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);
}
