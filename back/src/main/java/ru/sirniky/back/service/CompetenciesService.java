package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.request.CreateCompetenciesRequest;
import ru.sirniky.back.dto.response.CompetenciesResponse;

import java.util.List;

public interface CompetenciesService {
    List<CompetenciesResponse> getAllCompetencies();
    CompetenciesResponse getCompetenciesById(@Min(1) @NotNull Long id);
    CompetenciesResponse updateCompetencies(@Min(1) @NotNull Long id,@Valid CreateCompetenciesRequest request);
    void deleteCompetencies(@Min(1) @NotNull Long id);
     CompetenciesResponse saveCompetencies(@Valid CreateCompetenciesRequest competenciesRequest);

}
