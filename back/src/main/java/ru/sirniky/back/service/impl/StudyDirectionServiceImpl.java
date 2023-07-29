package ru.sirniky.back.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.request.CreateStudyDirectionRequest;
import ru.sirniky.back.dto.response.StudyDirectionResponse;
import ru.sirniky.back.entity.StudyDirection;
import ru.sirniky.back.exeptions.NotFoundException;
import ru.sirniky.back.mappers.StudyDirectionMapper;
import ru.sirniky.back.repositrores.EducationLevelRepository;
import ru.sirniky.back.repositrores.StudyDirectionRepository;
import ru.sirniky.back.service.StudyDirectionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class StudyDirectionServiceImpl implements StudyDirectionService {
    public static final String STUDY_DIRECTION_NOT_FOUND_WITH_ID = "Study direction not found with ID: ";
    public static final String NOT_FOUND_EDUCATION_LEVEL_WITH_ID = "Not found education level with id";

    private final StudyDirectionRepository studyDirectionRepository;
    private final StudyDirectionMapper studyDirectionMapper;
    private final EducationLevelRepository educationLevelRepository;

    @Override
    public List<StudyDirectionResponse> getAllStudyDirections() {
        List<StudyDirection> studyDirectionList = studyDirectionRepository.findAll();

        return studyDirectionList.stream()
                .map(studyDirectionMapper::toDto)
                .toList();
    }

    @Override
    public StudyDirectionResponse getStudyDirectionById(@Min(1) @NotNull Long id) {
        StudyDirection studyDirection = studyDirectionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(STUDY_DIRECTION_NOT_FOUND_WITH_ID + id));

        return studyDirectionMapper.toDto(studyDirection);
    }

    @Override
    @Transactional
    public StudyDirectionResponse saveStudyDirection(@Valid CreateStudyDirectionRequest directionRequest) {
        var educationLevel = educationLevelRepository.findById(directionRequest.educationLevelId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_EDUCATION_LEVEL_WITH_ID));

        StudyDirection studyDirection = studyDirectionMapper.toStudyDirection(directionRequest);
        studyDirection.setEducationLevel(educationLevel);
        studyDirection = studyDirectionRepository.save(studyDirection);

        return studyDirectionMapper.toDto(studyDirection);
    }

    @Override
    @Transactional
    public StudyDirectionResponse updateStudyDirection(@Min(1) @NotNull Long id, @Valid CreateStudyDirectionRequest directionRequest) {
        studyDirectionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(STUDY_DIRECTION_NOT_FOUND_WITH_ID + id));

        var educationLevel = educationLevelRepository.findById(directionRequest.educationLevelId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_EDUCATION_LEVEL_WITH_ID));

        StudyDirection existingStudyDirection = studyDirectionMapper.toStudyDirection(directionRequest);
        existingStudyDirection.setId(id);
        existingStudyDirection.setEducationLevel(educationLevel);
        existingStudyDirection = studyDirectionRepository.save(existingStudyDirection);

        return studyDirectionMapper.toDto(existingStudyDirection);
    }

    @Override
    @Transactional
    public void deleteStudyDirection(@Min(1) @NotNull Long id) {
        studyDirectionRepository.deleteById(id);
    }
}
