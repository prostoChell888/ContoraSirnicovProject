package ru.sirniky.back.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.request.CreateDisciplineRequest;
import ru.sirniky.back.dto.response.DisciplineResponse;
import ru.sirniky.back.service.DisciplineService;

import java.util.List;


@RestController
@RequestMapping("/disciplines")
@RequiredArgsConstructor

public class DisciplineController {
    private final DisciplineService disciplineService;



    @GetMapping
    public List<DisciplineResponse> getAllDisciplines() {
        return disciplineService.getAllDisciplines();
    }

    @GetMapping("/{id}")
    public DisciplineResponse getDisciplineById(@PathVariable Long id) {
        return disciplineService.getDisciplineById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DisciplineResponse createDiscipline(@RequestBody  CreateDisciplineRequest request) {
        return disciplineService.saveDiscipline(request);
    }

    @PutMapping("/{id}")
    public DisciplineResponse updateDiscipline(@PathVariable Long id, @RequestBody  CreateDisciplineRequest request) {
        return disciplineService.updateDiscipline(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscipline(@PathVariable Long id) {
        disciplineService.deleteDiscipline(id);
    }
}
