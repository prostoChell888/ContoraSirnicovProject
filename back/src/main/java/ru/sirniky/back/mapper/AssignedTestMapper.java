package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.sirniky.back.dto.request.AssignedTestRequest;
import ru.sirniky.back.dto.response.AssignedTestResponse;
import ru.sirniky.back.entity.Competencies;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.entity.test.AssignedTest;

@Mapper(componentModel = "spring")
public interface AssignedTestMapper {


    @Mapping(target = "testId", source = "test.id")
    @Mapping(target = "teacherId", source = "teacher.id")
    @Mapping(target = "studentIda", source = "students", qualifiedByName = "studentToId")
    AssignedTestResponse toDto(AssignedTest educationalProgram);


    @Named("studentToId")
    static Integer studentToId(Student student) {
        return student != null ? student.getId() : null;
    }

    AssignedTest toSource(AssignedTestRequest request);



}
