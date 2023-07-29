package ru.sirniky.back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.request.CreateEducationLevelRequest;
import ru.sirniky.back.dto.response.EducationLevelResponse;
import ru.sirniky.back.entity.EducationLevel;

@Mapper(componentModel = "spring")
public interface EducationLevelMapper {

    EducationLevelResponse toDto(EducationLevel educationLevel);

    @Mapping(target = "id", ignore = true)
    EducationLevel toEducationLevel(CreateEducationLevelRequest levelRequest);
}
