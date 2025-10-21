package com.marketmas.catalog.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DotenvConfig {

    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.load();

        System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
        System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
        System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));
    }
}