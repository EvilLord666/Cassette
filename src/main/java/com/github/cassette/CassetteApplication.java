package com.github.cassette;

import com.github.cassette.configuration.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CassetteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CassetteApplication.class, args);
    }

}
