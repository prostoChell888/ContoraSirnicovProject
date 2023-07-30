package ru.sirniky.back.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudyDirectionResponse {
        private Long id;
        private String directionCode;
        private String nameOfDirection;
        private String educationalProgram;
        private Long educationLevelId;
}