package ru.sirniky.back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.request.CreateStudyDirectionRequest;
import ru.sirniky.back.dto.response.StudyDirectionResponse;
import ru.sirniky.back.entity.StudyDirection;

@Mapper(componentModel = "spring")
public interface StudyDirectionMapper {

    @Mapping(target = "educationLevelId", source = "educationLevel.id")
    StudyDirectionResponse toDto(StudyDirection studyDirection);

    StudyDirection toStudyDirection(CreateStudyDirectionRequest directionRequest);
}
