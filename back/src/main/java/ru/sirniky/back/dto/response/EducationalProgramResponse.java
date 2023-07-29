package ru.sirniky.back.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationalProgramResponse {
        private Long id;
        private String name;
        private Long studyDirectionId;
}