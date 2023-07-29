package ru.sirniky.back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.sirniky.back.dto.request.CreateCompetenciesRequest;
import ru.sirniky.back.dto.response.CompetenciesResponse;
import ru.sirniky.back.entity.Competencies;
import ru.sirniky.back.entity.EducationalProgram;

@Mapper(componentModel = "spring")
public interface CompetenciesMapper {

    @Mapping(target = "educationalProgramIds", source = "educationalPrograms", qualifiedByName = "educationalProgramToId")
    CompetenciesResponse toDto(Competencies competencies);

    @Named("educationalProgramToId")
    static Long educationalProgramToId(EducationalProgram educationalProgramDTO) {
        return educationalProgramDTO != null ? educationalProgramDTO.getId() : null;
    }

    @Mapping(target = "educationalPrograms", ignore = true)
    Competencies toCompetencies(CreateCompetenciesRequest competenciesRequest);
}
