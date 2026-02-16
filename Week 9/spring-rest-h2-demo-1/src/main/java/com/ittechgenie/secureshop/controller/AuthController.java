package com.ittechgenie.secureshop.controller;

import com.ittechgenie.secureshop.dto.*;
import com.ittechgenie.secureshop.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest req) {
        authService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                java.util.Map.of("message", "User registered successfully")
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest req) {
        String token = authService.login(req);
        return ResponseEntity.ok(new LoginResponse(token)); // 200
    }
}
