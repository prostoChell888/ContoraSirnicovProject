package ru.sirniky.back.mappers;

import org.mapstruct.Mapper;
import ru.sirniky.back.dto.request.CreateEducationLevelRequest;
import ru.sirniky.back.dto.response.EducationLevelResponse;
import ru.sirniky.back.entity.EducationLevel;

@Mapper(componentModel = "spring")
public interface EducationLevelMapper {

    EducationLevelResponse toDto(EducationLevel educationLevel);

    EducationLevel toEducationLevel(CreateEducationLevelRequest levelRequest);
}
