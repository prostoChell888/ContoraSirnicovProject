package ru.sirniky.back.service;

import ru.sirniky.back.dto.TestDto;
import ru.sirniky.back.entity.test.Test;

import java.util.List;

public interface TestService {

    void create(TestDto testDto);

    List<Test> findAll();
}
