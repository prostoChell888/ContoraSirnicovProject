package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.request.CreateStudyDirectionRequest;
import ru.sirniky.back.dto.response.StudyDirectionResponse;

import java.util.List;

public interface StudyDirectionService {
    List<StudyDirectionResponse> getAllStudyDirections();

    StudyDirectionResponse getStudyDirectionById(@Min(1) @NotNull Long id);

    StudyDirectionResponse saveStudyDirection(@Valid CreateStudyDirectionRequest directionRequest);

    StudyDirectionResponse updateStudyDirection(@Min(1) @NotNull Long id, @Valid CreateStudyDirectionRequest directionRequest);

    void deleteStudyDirection(@Min(1) @NotNull Long id);
}
