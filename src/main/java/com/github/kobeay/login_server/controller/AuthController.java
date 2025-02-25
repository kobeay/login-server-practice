package com.github.kobeay.login_server.controller;

import com.github.kobeay.login_server.dto.RegisterRequest;
import com.github.kobeay.login_server.dto.RegisterResponse;
import com.github.kobeay.login_server.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "인증/인가")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @Operation(summary = "회원가입")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {

    }
}
