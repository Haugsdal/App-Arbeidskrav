package org.example.mailserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/*
* The main part of the Spring boot application. Loads all components, etc. on launch.
*/

@SpringBootApplication
@RestController
public class AppArbeidskravRiktigApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppArbeidskravRiktigApplication.class, args);
    }
    
}
