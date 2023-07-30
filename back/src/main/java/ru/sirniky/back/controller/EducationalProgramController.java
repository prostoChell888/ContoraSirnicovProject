package ru.sirniky.back.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.request.CreateEducationalProgramRequest;
import ru.sirniky.back.dto.response.EducationalProgramResponse;
import ru.sirniky.back.service.EducationalProgramService;

import java.util.List;


@RestController
@RequestMapping("/education-programs")
@RequiredArgsConstructor

public class EducationalProgramController {
    private final EducationalProgramService educationalProgramService;



    @GetMapping
    public List<EducationalProgramResponse> getAllEducationalPrograms() {
        return educationalProgramService.getAllEducationalPrograms();
    }

    @GetMapping("/{id}")
    public EducationalProgramResponse getEducationalProgramById(@PathVariable Long id) {
        return educationalProgramService.getEducationalProgramById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EducationalProgramResponse createEducationalProgram(@RequestBody @Valid CreateEducationalProgramRequest programRequest) {
        return educationalProgramService.saveEducationalProgram(programRequest);
    }

    @PutMapping("/{id}")
    public EducationalProgramResponse updateEducationalProgram(@PathVariable Long id, @RequestBody @Valid CreateEducationalProgramRequest programRequest) {
        return educationalProgramService.updateEducationalProgram(id, programRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteEducationalProgram(@PathVariable Long id) {
        educationalProgramService.deleteEducationalProgram(id);
    }
}
