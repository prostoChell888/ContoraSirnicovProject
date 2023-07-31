package ru.sirniky.back.service.impl;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.dto.request.AssignedTestRequest;
import ru.sirniky.back.dto.response.AssignedTestResponse;
import ru.sirniky.back.entity.test.AssignedTest;
import ru.sirniky.back.exeption.NotFoundException;
import ru.sirniky.back.mapper.AssignedTestMapper;
import ru.sirniky.back.repositrory.AssignedTestRepository;
import ru.sirniky.back.repositrory.StudentRepository;
import ru.sirniky.back.repositrory.TeacherRepository;
import ru.sirniky.back.service.AssignedTestService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class AssignedTestServiceImpl implements AssignedTestService {

    private final AssignedTestRepository assignedTestRepository;
    private final StudentRepository studentRepository;
    private final AssignedTestMapper assignedTestMapper;
    private final TeacherRepository teacherRepository;

    @Override
    public List<AssignedTestResponse> getAllTaskByStudId(@Min(1) @NotNull Integer studentId) {
        var student = studentRepository.findById(studentId).orElseThrow(() -> new NotFoundException("not found student with ID: " + studentId));
        var tests = assignedTestRepository.getAssignedTestByStudents(student);

        return tests.stream().map(assignedTestMapper::toDto).toList();
    }

    @Override
    public AssignedTestResponse createtaskForStudent(AssignedTestRequest assignedTestRequest) {
        teacherRepository
                .findById(assignedTestRequest.getTeacherId())
                .orElseThrow(() -> new NotFoundException(""));

        AssignedTest assignedTest = assignedTestMapper.toSource(assignedTestRequest);
        var res = assignedTestRepository.save(assignedTest);

        return assignedTestMapper.toDto(res);
    }
}
