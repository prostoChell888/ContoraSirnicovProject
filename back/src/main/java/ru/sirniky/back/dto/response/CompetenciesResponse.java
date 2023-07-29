package ru.sirniky.back.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompetenciesResponse {
    private Long id;
    private String categoryName;
    private String competenceCode;
    private String nameOfUniversalCompetence;
    private List<Long> educationalProgramIds;
}