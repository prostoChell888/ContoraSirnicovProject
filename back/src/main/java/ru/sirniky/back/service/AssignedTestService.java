package ru.sirniky.back.service;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import ru.sirniky.back.dto.response.AssignedTestResponse;

import java.util.List;

public interface AssignedTestService {


    List<AssignedTestResponse> getAllTaskByStudId(@Min(1) @NotNull Integer studentId);
}
