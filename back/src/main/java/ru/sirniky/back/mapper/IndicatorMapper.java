package ru.sirniky.back.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sirniky.back.dto.request.CreateIndicatorRequest;
import ru.sirniky.back.dto.response.IndicatorResponse;
import ru.sirniky.back.entity.Indicator;

@Mapper(componentModel = "spring")
public interface IndicatorMapper {

    @Mapping(target = "competenciesId", source =  "competenciesId.id")
    IndicatorResponse toDto(Indicator indicator);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "competenciesId.id", source =  "competenciesId")
    Indicator toIndicator(CreateIndicatorRequest indicatorRequest);
}

