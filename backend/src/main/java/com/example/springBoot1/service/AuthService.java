package com.example.springBoot1.service;

import com.example.springBoot1.model.LoginRequest;
import com.example.springBoot1.model.LoginResponse;
import com.example.springBoot1.model.SignupRequest;
import com.example.springBoot1.model.SignupResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    SignupResponse signup(SignupRequest signupRequest);
}
