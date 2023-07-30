package ru.sirniky.back.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DisciplineResponse {
        private Long id;
        private String indicatorCode;
        private List<Long> competencyIds;
}