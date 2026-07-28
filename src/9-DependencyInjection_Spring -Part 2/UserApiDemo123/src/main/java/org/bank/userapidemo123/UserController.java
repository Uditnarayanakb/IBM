package org.bank.userapidemo123;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public List<String> getUsers() {

        return List.of(
                "Udit",
                "John",
                "David"
        );
    }
}
