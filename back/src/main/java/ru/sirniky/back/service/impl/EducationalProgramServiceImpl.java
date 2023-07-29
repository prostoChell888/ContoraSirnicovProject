package ru.sirniky.back.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.request.CreateEducationalProgramRequest;
import ru.sirniky.back.dto.response.EducationalProgramResponse;
import ru.sirniky.back.entity.EducationalProgram;

import ru.sirniky.back.exeptions.NotFoundException;
import ru.sirniky.back.mappers.EducationalProgramMapper;

import ru.sirniky.back.repositrores.EducationLevelRepository;
import ru.sirniky.back.repositrores.EducationalProgramRepository;
import ru.sirniky.back.service.EducationalProgramService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class EducationalProgramServiceImpl implements EducationalProgramService {
    public static final String EDUCATIONAL_PROGRAM_NOT_FOUND_WITH_ID = "Educational program not found with ID: ";
    public static final String NOT_FOUND_EDUCATION_LEVEL_WITH_ID = "Not found education level with id";

    private final EducationalProgramRepository educationalProgramRepository;
    private final EducationalProgramMapper educationalProgramMapper;
    private final EducationLevelRepository educationLevelRepository;

    @Override
    public List<EducationalProgramResponse> getAllEducationalPrograms() {
        List<EducationalProgram> educationalProgramList = educationalProgramRepository.findAll();
        return educationalProgramList.stream()
                .map(educationalProgramMapper::toDto)
                .toList();
    }

    @Override
    public EducationalProgramResponse getEducationalProgramById(@Min(1) @NotNull Long id) {
        EducationalProgram educationalProgram = educationalProgramRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EDUCATIONAL_PROGRAM_NOT_FOUND_WITH_ID + id));

        return educationalProgramMapper.toDto(educationalProgram);
    }

    @Override
    @Transactional
    public EducationalProgramResponse saveEducationalProgram(@Valid CreateEducationalProgramRequest programRequest) {
        var educationLevel = educationLevelRepository.findById(programRequest.educationLevelId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_EDUCATION_LEVEL_WITH_ID));

        EducationalProgram educationalProgram = educationalProgramMapper.toEducationalProgram(programRequest);
        educationalProgram.setEducationLevel(educationLevel);
        educationalProgram = educationalProgramRepository.save(educationalProgram);

        return educationalProgramMapper.toDto(educationalProgram);
    }

    @Override
    @Transactional
    public EducationalProgramResponse updateEducationalProgram(@Min(1) @NotNull Long id, @Valid CreateEducationalProgramRequest programRequest) {
        educationalProgramRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EDUCATIONAL_PROGRAM_NOT_FOUND_WITH_ID + id));

        var educationLevel = educationLevelRepository.findById(programRequest.educationLevelId())
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_EDUCATION_LEVEL_WITH_ID));

        EducationalProgram existingEducationalProgram = educationalProgramMapper.toEducationalProgram(programRequest);
        existingEducationalProgram.setEducationLevel(educationLevel);
        existingEducationalProgram = educationalProgramRepository.save(existingEducationalProgram);

        return educationalProgramMapper.toDto(existingEducationalProgram);
    }

    @Override
    @Transactional
    public void deleteEducationalProgram(@Min(1) @NotNull Long id) {
        educationalProgramRepository.deleteById(id);
    }
}
