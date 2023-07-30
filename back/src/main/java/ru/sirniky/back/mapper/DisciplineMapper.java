package ru.sirniky.back.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.sirniky.back.dto.request.CreateDisciplineRequest;
import ru.sirniky.back.dto.response.DisciplineResponse;
import ru.sirniky.back.entity.Competencies;
import ru.sirniky.back.entity.Discipline;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {

    @Mapping(target = "competencyIds", source = "competencies", qualifiedByName = "competenciesToId")
    DisciplineResponse toDto(Discipline discipline);

    @Named("competenciesToId")
    static Long competenciesToId(Competencies competencies) {
        return competencies != null ? competencies.getId() : null;
    }

    @Mapping(target = "competencies", ignore = true)
    Discipline toDiscipline(CreateDisciplineRequest disciplineRequest);
}

