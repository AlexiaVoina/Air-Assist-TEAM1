package com.example.springBoot1.controller;

import com.example.springBoot1.model.*;
import com.example.springBoot1.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@Validated
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService AuthService;

    @Autowired
    public AuthController(AuthService AuthService) {
        this.AuthService = AuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        log.info("Login request received : {}", loginRequest);

        LoginResponse loginResponse = AuthService.login(loginRequest);
        log.info("Logged in user: {}", loginResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(loginResponse);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest){
        log.info("Signup request received : {}", signupRequest);

        SignupResponse signupResponse = AuthService.signup(signupRequest);
        log.info("Signed up  user: {}", signupResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(signupResponse);
    }
}
