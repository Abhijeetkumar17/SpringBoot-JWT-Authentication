package com.security.service;

import com.security.dto.LoginRequest;
import com.security.dto.RegisterRequest;
import com.security.entity.User;
import com.security.repository.UserRepository;

import com.security.security.JwtUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // important fix
        user.setRole("ROLE_" + request.getRole());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // LOGIN
    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getEmail());
    }
}