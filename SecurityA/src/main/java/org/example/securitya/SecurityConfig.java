package org.example.securitya;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> {

                    registry.requestMatchers("/home").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
                .username("med")
                .password("$2y$10$11TYrkzD7qM4aY0Ieg.tU.LWAQhvhFRHKGoh59Hjl6FctDFnRoiAK") //12345   $2y$10$11TYrkzD7qM4aY0Ieg.tU.LWAQhvhFRHKGoh59Hjl6FctDFnRoiAK
                .roles("USER")
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password("$2y$10$T.9C/cnHxnBEtfDBva50aOX2Bop/UWP4x1pxl0Jc6uvFj2yja5hc2") //6789
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
