package org.example.javaemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to,
                            String subject,
                            String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mohamedabail414@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

        System.out.println("Email sent successfully");
    }
}
