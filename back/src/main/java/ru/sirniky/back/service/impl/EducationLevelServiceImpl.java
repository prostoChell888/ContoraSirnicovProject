package ru.sirniky.back.service.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.request.CreateEducationLevelRequest;
import ru.sirniky.back.dto.response.EducationLevelResponse;
import ru.sirniky.back.entity.EducationLevel;
import ru.sirniky.back.exeption.NotFoundException;
import ru.sirniky.back.mapper.EducationLevelMapper;
import ru.sirniky.back.repositrory.EducationLevelRepository;
import ru.sirniky.back.service.EducationLevelService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class EducationLevelServiceImpl implements EducationLevelService {
    public static final String EDUCATION_LEVEL_NOT_FOUND_WITH_ID = "Education level not found with ID: ";

    private final EducationLevelRepository educationLevelRepository;
    private final EducationLevelMapper educationLevelMapper;

    @Override
    public List<EducationLevelResponse> getAllEducationLevels() {
        List<EducationLevel> educationLevelList = educationLevelRepository.findAll();
        return educationLevelList.stream()
                .map(educationLevelMapper::toDto)
                .toList();
    }

    @Override
    public EducationLevelResponse getEducationLevelById(@Min(1) @NotNull Long id) {
        EducationLevel educationLevel = educationLevelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EDUCATION_LEVEL_NOT_FOUND_WITH_ID + id));

        return educationLevelMapper.toDto(educationLevel);
    }

    @Override
    @Transactional
    public EducationLevelResponse saveEducationLevel(@Valid CreateEducationLevelRequest levelRequest) {
        EducationLevel educationLevel = educationLevelMapper.toEducationLevel(levelRequest);
        educationLevel = educationLevelRepository.save(educationLevel);

        return educationLevelMapper.toDto(educationLevel);
    }

    @Override
    @Transactional
    public EducationLevelResponse updateEducationLevel(@Min(1) @NotNull Long id, @Valid CreateEducationLevelRequest levelRequest) {
        educationLevelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EDUCATION_LEVEL_NOT_FOUND_WITH_ID + id));

        EducationLevel existingEducationLevel = educationLevelMapper.toEducationLevel(levelRequest);
        existingEducationLevel.setId(id);
        existingEducationLevel = educationLevelRepository.save(existingEducationLevel);

        return educationLevelMapper.toDto(existingEducationLevel);
    }

    @Override
    @Transactional
    public void deleteEducationLevel(@Min(1) @NotNull Long id) {
        educationLevelRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EDUCATION_LEVEL_NOT_FOUND_WITH_ID + id));
        educationLevelRepository.deleteById(id);
    }
}
