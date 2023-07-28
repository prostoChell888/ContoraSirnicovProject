package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import ru.sirniky.back.dto.TeacherDto;
import ru.sirniky.back.entity.Teacher;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    Teacher toEntity(TeacherDto teacher);

    TeacherDto toDto(Teacher teacher);
}
