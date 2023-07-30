package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.sirniky.back.dto.StudentDto;
import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.entity.Group;
import ru.sirniky.back.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    @Mapping(target = "group.name", source = "group" )
    Student toEntity(StudentDto studentDto);

    @Mapping(target = "group", source =  "group.name")
    StudentDto toDto(Student student);

    @Mapping(target = "password", source = "password")
    @Mapping(target = "group", source = "student.group.name")
    StudentWithPasswordDto toDtoWithPassword(Student student, String password);

}
