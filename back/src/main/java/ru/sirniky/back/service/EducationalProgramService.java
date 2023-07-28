package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.EducationalProgram;
import ru.sirniky.back.repositrores.EducationalProgramRepository;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class EducationalProgramService {
    private final EducationalProgramRepository educationalProgramRepository;

    @Autowired
    public EducationalProgramService(EducationalProgramRepository educationalProgramRepository) {
        this.educationalProgramRepository = educationalProgramRepository;
    }

    public List<EducationalProgram> getAllEducationalPrograms() {
        return educationalProgramRepository.findAll();
    }

    public Optional<EducationalProgram> getEducationalProgramById(@Min(1)@NotNull Long id) {
        return educationalProgramRepository.findById(id);
    }

    public EducationalProgram saveEducationalProgram(@Valid EducationalProgram educationalProgram) {
        return educationalProgramRepository.save(educationalProgram);
    }

    public EducationalProgram updateEducationalProgram(@Valid EducationalProgram educationalProgram) {
        return educationalProgramRepository.save(educationalProgram);
    }

    public void deleteEducationalProgram(@Min(1)@NotNull Long id) {
        educationalProgramRepository.deleteById(id);
    }
}
