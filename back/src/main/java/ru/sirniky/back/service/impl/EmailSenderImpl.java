package ru.sirniky.back.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.sirniky.back.dto.StudentWithPasswordDto;
import ru.sirniky.back.service.EmailService;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendPasswordToEmail(StudentWithPasswordDto student) {
        var message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(student.getEmail());
        message.setSubject("Ваши данные для входа в личный кабинет");
        message.setText("Логин : " + student.getEmail() + "\n Пароль : " + student.getPassword());

        javaMailSender.send(message);
    }
}
