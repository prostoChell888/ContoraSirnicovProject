package ru.sirniky.back.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.StudyDirection;
import ru.sirniky.back.repositrores.StudyDirectionRepository;
import jakarta.validation.constraints.NotNull;


import java.util.List;
import java.util.Optional;

@Service
@Validated
public class StudyDirectionService {
    private final StudyDirectionRepository studyDirectionRepository;

    @Autowired
    public StudyDirectionService(StudyDirectionRepository studyDirectionRepository) {
        this.studyDirectionRepository = studyDirectionRepository;
    }

    public List<StudyDirection> getAllStudyDirections() {
        return studyDirectionRepository.findAll();
    }

    public Optional<StudyDirection> getStudyDirectionById(@Min(1)@NotNull Long id) {
        return studyDirectionRepository.findById(id);
    }

    public StudyDirection saveStudyDirection(@Valid StudyDirection studyDirection) {
        return studyDirectionRepository.save(studyDirection);
    }

    public StudyDirection updateStudyDirection(@Valid StudyDirection studyDirection) {
        return studyDirectionRepository.save(studyDirection);
    }

    public void deleteStudyDirection(@Min(1)@NotNull Long id) {
        studyDirectionRepository.deleteById(id);
    }
}
