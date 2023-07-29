package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.request.CreateEducationalProgramRequest;
import ru.sirniky.back.dto.response.EducationalProgramResponse;

import java.util.List;

public interface EducationalProgramService {
    List<EducationalProgramResponse> getAllEducationalPrograms();

    EducationalProgramResponse getEducationalProgramById(@Min(1) @NotNull Long id);

    EducationalProgramResponse saveEducationalProgram(@Valid CreateEducationalProgramRequest programRequest);

    EducationalProgramResponse updateEducationalProgram(@Min(1) @NotNull Long id, @Valid CreateEducationalProgramRequest programRequest);

    void deleteEducationalProgram(@Min(1) @NotNull Long id);
}
