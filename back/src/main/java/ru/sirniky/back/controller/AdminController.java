package ru.sirniky.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sirniky.back.dto.StudentDto;
import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.dto.TeacherDto;
import ru.sirniky.back.mapper.StudentMapper;
import ru.sirniky.back.mapper.TeacherMapper;
import ru.sirniky.back.service.EmailService;
import ru.sirniky.back.service.ExcelService;
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
    private final EmailService emailService;

    private final ExcelService excelService;


    @PostMapping("/create/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto createStudent(@RequestBody StudentDto student) {
        StudentWithPasswordDto studentWithPassword = studentService.createStudent(student);

//        emailService.sendPasswordToEmail(studentWithPassword);

        return studentWithPassword;
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

    @GetMapping("/excel/students")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity <byte[]> getExcelWithAllStudents() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "studentsData.xlsx");

        // Возвращаем массив байтов Excel файла в теле ответа
        return ResponseEntity.ok()
                .headers(headers)
                .body(excelService.getExcelWithAllStudents());
    }
}
