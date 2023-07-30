package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.sirniky.back.entity.Student;
import ru.sirniky.back.service.ExcelService;
import ru.sirniky.back.service.StudentService;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class ExcelServiceImpl implements ExcelService {

    private final StudentService studentService;

    @Override
    public byte[] getExcelWithAllStudents() {

        List<Student> studentList = studentService.getAllStudent();

        Workbook workbook = new XSSFWorkbook();

        // Создаем новый лист в документе
        Sheet sheet = workbook.createSheet("Sheet1");

        // Создаем заголовок для колонок
        String[] headers = {"Фамилия", "Имя", "Отчество", "ID (№ зачетной книжки)", "Группа"};
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Заполняем данные в документе
        int rowNum = 1;

        for (Student student : studentList) {
            String[] fullName = student.getFullName().split(" ");
            Row dataRow = sheet.createRow(rowNum++);
            dataRow.createCell(0).setCellValue(fullName[0]);
            dataRow.createCell(1).setCellValue(fullName[1]);
            dataRow.createCell(2).setCellValue(fullName[2]);
            dataRow.createCell(3).setCellValue(student.getRecordBook());
            dataRow.createCell(4).setCellValue(student.getGroup().getName());
        }

        // Сохраняем документ Excel в массив байтов
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            workbook.write(outputStream);
            workbook.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return outputStream.toByteArray();

        // Устанавливаем заголовки для ответа
    }

}
