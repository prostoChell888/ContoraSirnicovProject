package ru.sirniky.back.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sirniky.back.entity.Test;
import ru.sirniky.back.entity.dto.TestDto;
import ru.sirniky.back.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/all")
    public List<Test> getAll() {
        return testService.findAll();
    }

    @PostMapping("/create")
    public void createTest(@RequestBody TestDto testDto){
        testService.create(testDto);
    }
}
