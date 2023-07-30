package ru.sirniky.back.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.request.CreateEducationLevelRequest;
import ru.sirniky.back.dto.response.EducationLevelResponse;
import ru.sirniky.back.service.EducationLevelService;

import java.util.List;


@RestController
@RequestMapping("/education-levels")
@RequiredArgsConstructor

public class EducationLevelController {
    private final EducationLevelService educationLevelService;



    @GetMapping
    public List<EducationLevelResponse> getAllEducationLevels() {
        return educationLevelService.getAllEducationLevels();
    }

    @GetMapping("/{id}")
    public EducationLevelResponse getEducationLevelById(@PathVariable Long id) {
        return educationLevelService.getEducationLevelById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EducationLevelResponse createEducationLevel(@RequestBody @Valid CreateEducationLevelRequest request) {
        return educationLevelService.saveEducationLevel(request);
    }

    @PutMapping("/{id}")
    public EducationLevelResponse updateEducationLevel(@PathVariable Long id, @RequestBody @Valid CreateEducationLevelRequest request) {
        return educationLevelService.updateEducationLevel(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteEducationLevel(@PathVariable Long id) {
        educationLevelService.deleteEducationLevel(id);
    }
}

