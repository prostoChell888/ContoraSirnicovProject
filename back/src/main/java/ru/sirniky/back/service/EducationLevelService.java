package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.request.CreateEducationLevelRequest;
import ru.sirniky.back.dto.response.EducationLevelResponse;

import java.util.List;

public interface EducationLevelService {
    List<EducationLevelResponse> getAllEducationLevels();

    EducationLevelResponse getEducationLevelById(@Min(1) @NotNull Long id);

    EducationLevelResponse saveEducationLevel(@Valid CreateEducationLevelRequest levelRequest);

    EducationLevelResponse updateEducationLevel(@Min(1) @NotNull Long id, @Valid CreateEducationLevelRequest levelRequest);

    void deleteEducationLevel(@Min(1) @NotNull Long id);
}
