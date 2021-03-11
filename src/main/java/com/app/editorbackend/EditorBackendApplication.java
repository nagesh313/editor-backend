package com.app.editorbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class EditorBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(EditorBackendApplication.class, args);
    }
}
