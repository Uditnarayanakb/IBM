package org.bank.userapidemo123;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiDemo123Application {

    public static void main(String[] args) {

        args = new String[]{
                "Udit"
        };

        System.out.println("Name: " + args[0]);

        SpringApplication.run(UserApiDemo123Application.class, args);
    }
}