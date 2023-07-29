package ru.sirniky.back.controlers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.request.CreateCompetenciesRequest;
import ru.sirniky.back.dto.response.CompetenciesResponse;
import ru.sirniky.back.service.CompetenciesService;

import java.util.List;


@RestController
@RequestMapping("/competencies")
@RequiredArgsConstructor
public class CompetenciesController {
    private final CompetenciesService competenciesService;



    @GetMapping
    public List<CompetenciesResponse> getAllCompetencies() {
        return competenciesService.getAllCompetencies();
    }

    @GetMapping("/{id}")
    public CompetenciesResponse getCompetenciesById(@PathVariable Long id) {
        return competenciesService.getCompetenciesById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetenciesResponse createCompetencies(@RequestBody  CreateCompetenciesRequest request) {
        return competenciesService.saveCompetencies(request);
    }

    @PutMapping("/{id}")
    public CompetenciesResponse updateCompetencies(@PathVariable Long id, @RequestBody  CreateCompetenciesRequest request) {
        return competenciesService.updateCompetencies(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCompetencies(@PathVariable Long id) {
        competenciesService.deleteCompetencies(id);
    }
}
