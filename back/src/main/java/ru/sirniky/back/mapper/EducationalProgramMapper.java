package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.request.CreateEducationalProgramRequest;
import ru.sirniky.back.dto.response.EducationalProgramResponse;
import ru.sirniky.back.entity.EducationalProgram;

@Mapper(componentModel = "spring")
public interface EducationalProgramMapper {

    EducationalProgramResponse toDto(EducationalProgram educationalProgram);

    @Mapping(target =  "studyDirection.id", source = "studyDirectionId")
    EducationalProgram toEducationalProgram(CreateEducationalProgramRequest programRequest);
}