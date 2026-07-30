package org.bank.cachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class cacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                cacheDemoApplication.class,
                args);
    }
}