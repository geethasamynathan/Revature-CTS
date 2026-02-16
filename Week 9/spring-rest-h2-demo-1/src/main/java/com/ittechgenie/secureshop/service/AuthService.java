package com.ittechgenie.secureshop.service;

import com.ittechgenie.secureshop.dto.*;
import com.ittechgenie.secureshop.entity.AppUser;
import com.ittechgenie.secureshop.exception.ApiException;
import com.ittechgenie.secureshop.repo.*;
import com.ittechgenie.secureshop.security.JwtService;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepo, RoleRepository roleRepo,
                       PasswordEncoder encoder, AuthenticationManager authManager,
                       JwtService jwtService) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest req) {
        if (userRepo.existsByUsername(req.username())) {
            throw new ApiException("Username already exists");
        }

        var roleUser = roleRepo.findByName("ROLE_USER")
                .orElseThrow(() -> new ApiException("ROLE_USER missing. Seed roles first."));

        AppUser user = new AppUser(req.username(), encoder.encode(req.password()));
        user.getRoles().add(roleUser);

        userRepo.save(user);
    }

    public String login(LoginRequest req) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.username(), req.password())
            );
        } catch (BadCredentialsException ex) {
            // industry standard: 401
            throw new ApiException("Invalid username/password");
        }

        return jwtService.generateToken(req.username());
    }
}
