package com.github.kobeay.login_server.controller;

import com.github.kobeay.login_server.constant.EntityStatus;
import com.github.kobeay.login_server.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    @GetMapping
    public String checkHealth() {
        User user = getUser();
        return "OK";
    }

    private User getUser() {
        return new User("user", "pass", EntityStatus.ACTIVE);
    }
}
