package ru.sirniky.back.controler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.request.CreateIndicatorRequest;
import ru.sirniky.back.dto.response.IndicatorResponse;
import ru.sirniky.back.service.IndicatorService;

import java.util.List;


@RestController
@RequestMapping("/indicators")
@RequiredArgsConstructor

public class IndicatorController {
    private final IndicatorService indicatorService;



    @GetMapping
    public List<IndicatorResponse> getAllIndicators() {
        return indicatorService.getAllIndicators();
    }

    @GetMapping("/{id}")
    public IndicatorResponse getIndicatorById(@PathVariable Long id) {
        return indicatorService.getIndicatorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IndicatorResponse createIndicator(@RequestBody @Valid CreateIndicatorRequest request) {
        return indicatorService.saveIndicator(request);
    }

    @PutMapping("/{id}")
    public IndicatorResponse updateIndicator(@PathVariable Long id, @RequestBody @Valid CreateIndicatorRequest request) {
        return indicatorService.updateIndicator(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteIndicator(@PathVariable Long id) {
        indicatorService.deleteIndicator(id);
    }
}

