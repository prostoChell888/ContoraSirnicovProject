package ru.sirniky.back.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndicatorResponse {
        private Long id;
        private String indicatorCode;
        private String nameOfIndicator;
        private Long competenciesId;
}