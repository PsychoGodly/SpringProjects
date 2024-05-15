package org.example.testquartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestQuartzApplication.class, args);
    }

}
