package com.asdaq.taskmanager.controller;

import com.asdaq.taskmanager.dto.LoginRequest;
import com.asdaq.taskmanager.dto.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return new LoginResponse(
                auth.getName(),
                auth.getAuthorities().iterator().next().getAuthority(),
                "Login successful"
        );
    }
}
