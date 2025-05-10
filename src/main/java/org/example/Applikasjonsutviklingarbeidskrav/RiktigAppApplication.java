package org.example.Applikasjonsutviklingarbeidskrav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/*
* The main part of the Spring boot application. Loads all components, etc. on launch.
*/

@SpringBootApplication
@RestController
public class RiktigAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiktigAppApplication.class, args);
    }
    
}
