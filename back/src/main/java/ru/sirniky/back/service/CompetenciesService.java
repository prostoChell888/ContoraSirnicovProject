package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.Competencies;
import ru.sirniky.back.repositrores.CompetenciesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class CompetenciesService {
    private final CompetenciesRepository competenciesRepository;

    @Autowired
    public CompetenciesService(CompetenciesRepository competenciesRepository) {
        this.competenciesRepository = competenciesRepository;
    }

    public List<Competencies> getAllCompetencies() {
        return competenciesRepository.findAll();
    }

    public Optional<Competencies> getCompetenciesById(@Min(1)@NotNull Long id) {
        return competenciesRepository.findById(id);
    }

    public Competencies saveCompetencies(@Valid Competencies competencies) {
        return competenciesRepository.save(competencies);
    }

    public Competencies updateCompetencies(@Valid Competencies competencies) {
        return competenciesRepository.save(competencies);
    }

    public void deleteCompetencies(@Min(1)@NotNull Long id) {
        competenciesRepository.deleteById(id);
    }
}
