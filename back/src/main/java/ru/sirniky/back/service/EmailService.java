package ru.sirniky.back.service;

import ru.sirniky.back.dto.StudentWithPasswordDto;

public interface EmailService {

    void sendPasswordToEmail(StudentWithPasswordDto student);
}
