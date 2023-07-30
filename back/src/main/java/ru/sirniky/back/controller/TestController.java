package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sirniky.back.entity.test.Test;
import ru.sirniky.back.dto.TestDto;
import ru.sirniky.back.service.Impl.TestServiceImpl;
import ru.sirniky.back.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testServiceImpl;

    @GetMapping("/all")
    public List<Test> getAll() {
        return testServiceImpl.findAll();
    }

    @PostMapping("/create")
    public void createTest(@RequestBody TestDto testDto){
        testServiceImpl.create(testDto);
    }
}
