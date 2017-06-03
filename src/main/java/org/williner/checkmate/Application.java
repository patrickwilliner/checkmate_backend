package org.williner.checkmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.williner.checkmate")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
