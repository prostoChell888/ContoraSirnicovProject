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
    StudentWithPasswordDto toDtoWithPassword( String password);

    @Named("mapGroupToString")
    static String mapGroupToString(Group group) {
        // Implement the conversion logic here
        // For example, if the Group has a property named "name", you can use:
        // return group.getName();
        return null; // Replace this with the actual conversion logic
    }
}
