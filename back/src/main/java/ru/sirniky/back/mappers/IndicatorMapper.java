package ru.sirniky.back.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.request.CreateIndicatorRequest;
import ru.sirniky.back.dto.response.IndicatorResponse;
import ru.sirniky.back.entity.Indicator;

@Mapper(componentModel = "spring")
public interface IndicatorMapper {

    @Mapping(target = "competenciesId", source = "competencies.id")
    IndicatorResponse toDto(Indicator indicator);

    Indicator toIndicator(CreateIndicatorRequest indicatorRequest);
}

