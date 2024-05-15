package org.example.testquartz;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailJob implements Job {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo("mohamedabail.in@gmail.com");
            helper.setSubject("Quartz Test");
            helper.setText("Contenu de l'e-mail : Test Quartz 1.");
            javaMailSender.send(message);
            System.out.println("E-mail envoyé avec succès !");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new JobExecutionException("Erreur lors de l'envoi de l'e-mail", e);
        }
    }
}
