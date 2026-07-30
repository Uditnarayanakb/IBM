package org.bank.cachedemo;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService service;

    public UserController(
            UserService service) {

        this.service = service;
    }

    @GetMapping("/user/{id}")
    public String getUser(
            @PathVariable Long id) {

        return service.getUser(id);
    }
}