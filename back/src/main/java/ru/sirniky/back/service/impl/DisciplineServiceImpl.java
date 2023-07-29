package ru.sirniky.back.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.request.CreateDisciplineRequest;
import ru.sirniky.back.dto.response.DisciplineResponse;
import ru.sirniky.back.entity.Discipline;
import ru.sirniky.back.exeptions.NotFoundException;
import ru.sirniky.back.mappers.DisciplineMapper;
import ru.sirniky.back.repositrores.CompetenciesRepository;
import ru.sirniky.back.repositrores.DisciplineRepository;
import ru.sirniky.back.service.DisciplineService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class DisciplineServiceImpl implements DisciplineService {
    public static final String DISCIPLINE_NOT_FOUND_WITH_ID = "Discipline not found with ID: ";
    public static final String NOT_FOUND_COMPETENCIES_WITH_ID = "Not found competencies with id";

    private final DisciplineRepository disciplineRepository;
    private final DisciplineMapper disciplineMapper;
    private final CompetenciesRepository competenciesRepository;

    @Override
    public List<DisciplineResponse> getAllDisciplines() {
        List<Discipline> disciplineList = disciplineRepository.findAll();
        return disciplineList.stream()
                .map(disciplineMapper::toDto)
                .toList();
    }

    @Override
    public DisciplineResponse getDisciplineById(@Min(1) @NotNull Long id) {
        Discipline discipline = disciplineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(DISCIPLINE_NOT_FOUND_WITH_ID + id));

        return disciplineMapper.toDto(discipline);
    }

    @Override
    @Transactional
    public DisciplineResponse saveDiscipline(@Valid CreateDisciplineRequest disciplineRequest) {
        var findingIds = competenciesRepository.findAllById(disciplineRequest.competenciesIds());
        if (findingIds.size() != disciplineRequest.competenciesIds().size()) {
            throw new NotFoundException(NOT_FOUND_COMPETENCIES_WITH_ID);
        }
        Discipline discipline = disciplineMapper.toDiscipline(disciplineRequest);
        discipline.setCompetencies(findingIds);
        discipline = disciplineRepository.save(discipline);

        return disciplineMapper.toDto(discipline);
    }

    @Override
    @Transactional
    public DisciplineResponse updateDiscipline(@Min(1) @NotNull Long id, @Valid CreateDisciplineRequest disciplineRequest) {
        disciplineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(DISCIPLINE_NOT_FOUND_WITH_ID + id));

        var findingCompetenciesIds = competenciesRepository.findAllById(disciplineRequest.competenciesIds());
        if (findingCompetenciesIds.size() != disciplineRequest.competenciesIds().size()) {
            throw new NotFoundException(NOT_FOUND_COMPETENCIES_WITH_ID);
        }
        var existingDiscipline = disciplineMapper.toDiscipline(disciplineRequest);
        existingDiscipline.setCompetencies(findingCompetenciesIds);
        existingDiscipline = disciplineRepository.save(existingDiscipline);

        return disciplineMapper.toDto(existingDiscipline);
    }

    @Override
    @Transactional
    public void deleteDiscipline(@Min(1) @NotNull Long id) {
        disciplineRepository.deleteById(id);
    }
}
