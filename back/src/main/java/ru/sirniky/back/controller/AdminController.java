package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.StudentDto;
import ru.sirniky.back.dto.TeacherDto;
import ru.sirniky.back.mapper.StudentMapper;
import ru.sirniky.back.mapper.TeacherMapper;
import ru.sirniky.back.service.StudentService;
import ru.sirniky.back.service.TeacherService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;
    private final StudentService studentService;
    private final StudentMapper studentMapper;


    @PostMapping("/create/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto createStudent(@RequestBody StudentDto student) {
        return studentMapper.toDto(studentService.createStudent(student));
    }

    @DeleteMapping("/delete/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }


    @PostMapping("/create/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDto createStudent(@RequestBody TeacherDto teacherDto) {
        return teacherMapper.toDto(teacherService.createTeacher(teacherDto));
    }
}
