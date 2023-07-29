package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.request.CreateDisciplineRequest;
import ru.sirniky.back.dto.response.DisciplineResponse;

import java.util.List;

public interface DisciplineService {
    List<DisciplineResponse> getAllDisciplines();

    DisciplineResponse getDisciplineById(@Min(1) @NotNull Long id);

    DisciplineResponse saveDiscipline(@Valid CreateDisciplineRequest disciplineRequest);

    DisciplineResponse updateDiscipline(@Min(1) @NotNull Long id, @Valid CreateDisciplineRequest disciplineRequest);

    void deleteDiscipline(@Min(1) @NotNull Long id);
}

