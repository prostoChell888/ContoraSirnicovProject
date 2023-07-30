package ru.sirniky.back.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.request.CreateStudyDirectionRequest;
import ru.sirniky.back.dto.response.StudyDirectionResponse;
import ru.sirniky.back.service.StudyDirectionService;

import java.util.List;

@RestController
@RequestMapping("/study-directions")
@RequiredArgsConstructor

public class StudyDirectionController {
    private final StudyDirectionService studyDirectionService;

    @GetMapping
    public List<StudyDirectionResponse> getAllStudyDirections() {
        return studyDirectionService.getAllStudyDirections();
    }

    @GetMapping("/{id}")
    public StudyDirectionResponse getStudyDirectionById(@PathVariable Long id) {
        return studyDirectionService.getStudyDirectionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudyDirectionResponse createStudyDirection(@RequestBody @Valid CreateStudyDirectionRequest request) {
        return studyDirectionService.saveStudyDirection(request);
    }

    @PutMapping("/{id}")
    public StudyDirectionResponse updateStudyDirection(@PathVariable Long id, @RequestBody @Valid CreateStudyDirectionRequest request) {
        return studyDirectionService.updateStudyDirection(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteStudyDirection(@PathVariable Long id) {
        studyDirectionService.deleteStudyDirection(id);
    }
}

