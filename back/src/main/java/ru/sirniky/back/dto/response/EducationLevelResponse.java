package ru.sirniky.back.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducationLevelResponse {
        private Long id;
        private String label;
        private String ugsnCode;
        private String ugsnLabel;
        private String directionCode;
}