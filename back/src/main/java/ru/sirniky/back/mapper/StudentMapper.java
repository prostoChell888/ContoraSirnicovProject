package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "password", ignore = true)
    Student toEntity(StudentWithPasswordDto studentDto);
}
