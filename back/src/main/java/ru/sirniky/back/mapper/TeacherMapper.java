package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.dto.TeacherWithPasswordDto;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.entity.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    @Mapping(target = "password", ignore = true)
    Teacher toEntity(TeacherWithPasswordDto teacher);
}
