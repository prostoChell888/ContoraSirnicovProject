package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.Discipline;
import ru.sirniky.back.repositrores.DisciplineRepository;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    public Optional<Discipline> getDisciplineById(@Min(1)@NotNull Long id) {
        return disciplineRepository.findById(id);
    }

    public Discipline saveDiscipline(@Valid Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public Discipline updateDiscipline(@Valid Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(@Min(1)@NotNull Long id) {
        disciplineRepository.deleteById(id);
    }
}
