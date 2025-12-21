package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthResponse register(RegisterRequest request) {
        // dummy logic for now
        return new AuthResponse("REGISTER_SUCCESS");
    }

    public AuthResponse login(AuthRequest request) {
        // dummy logic for now
        return new AuthResponse("LOGIN_SUCCESS");
    }
}
