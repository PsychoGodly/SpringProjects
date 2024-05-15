package org.example.javaemail;
import org.example.javaemail.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JavaEmailApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(JavaEmailApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        senderService.sendEmail("mohamedabail.in@gmail.com",
                                    "Test",
                                        "Hello there");
    }

}
