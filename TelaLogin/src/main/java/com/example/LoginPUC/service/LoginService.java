package com.example.LoginPUC.service;

import com.example.LoginPUC.exception.LoginException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final JavaMailSender mailSender;

    public LoginService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom("lexandre.guimaraes@gmail.com");

            mailSender.send(message);
        } catch (MailException e) {
            throw new LoginException("Falha ao enviar e-mail: " + e.getMessage());
        }
    }
}