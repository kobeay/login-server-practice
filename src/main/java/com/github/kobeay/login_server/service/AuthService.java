package com.github.kobeay.login_server.service;

import com.github.kobeay.login_server.constant.EntityStatus;
import com.github.kobeay.login_server.dto.RegisterRequest;
import com.github.kobeay.login_server.dto.RegisterResponse;
import com.github.kobeay.login_server.entity.User;
import com.github.kobeay.login_server.repository.UserRepository;
import com.github.kobeay.login_server.validator.JwtValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtValidator jwtValidator;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtValidator jwtValidator, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtValidator = jwtValidator;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public RegisterResponse register(RegisterRequest registerRequest) {
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        User user = new User(registerRequest.getUsername(), encodedPassword, EntityStatus.ACTIVE);
        User newUser = userRepository.save(user);
        return RegisterResponse.builder()
                .id(newUser.getId())
                .username(newUser.getUsername())
                .roles(newUser.getRoles())
                .status(newUser.getStatus())
                .createdAt(newUser.getCreatedAt())
                .updateAt(newUser.getUpdatedAt())
                .build();
    }
}
