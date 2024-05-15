package org.example.securitya;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorConfig {

    @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return registry -> {
            registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            registry.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403.html"));
        };
    }
}
