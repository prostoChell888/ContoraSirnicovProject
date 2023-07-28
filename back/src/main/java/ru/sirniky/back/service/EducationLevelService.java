package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.EducationLevel;
import ru.sirniky.back.repositrores.EducationLevelRepository;
import jakarta.validation.constraints.NotNull;


import java.util.List;
import java.util.Optional;

@Service
@Validated
public class EducationLevelService {
    private final EducationLevelRepository educationLevelRepository;

    @Autowired
    public EducationLevelService(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    public List<EducationLevel> getAllEducationLevels() {
        return educationLevelRepository.findAll();
    }

    public Optional<EducationLevel> getEducationLevelById(@Min(1)@NotNull Long id) {
        return educationLevelRepository.findById(id);
    }

    public EducationLevel saveEducationLevel(@Valid EducationLevel educationLevel) {
        return educationLevelRepository.save(educationLevel);
    }

    public EducationLevel updateEducationLevel(@Valid EducationLevel educationLevel) {
        return educationLevelRepository.save(educationLevel);
    }

    public void deleteEducationLevel(@Min(1)@NotNull Long id) {
        educationLevelRepository.deleteById(id);
    }
}
