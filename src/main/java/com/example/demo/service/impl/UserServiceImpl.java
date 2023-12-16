package com.example.demo.service.impl;

import com.example.demo.config.jwtConfig.JwtService;
import com.example.demo.dto.request.auth.SignInRequest;
import com.example.demo.dto.request.auth.SignUpRequest;
import com.example.demo.dto.response.auth.AuthenticationResponse;
import com.example.demo.entity.User;
import com.example.demo.enums.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        log.info("Signing up");
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new RuntimeException("Sorry, this email is already registered. Please try a different email or login to your existing account");
        }
        User newUser = User.builder()
                .userName(signUpRequest.getUserName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(newUser);

        var jwtToken = jwtService.generateToken(newUser);

        log.info("Sign up successful");

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.findUserByEmail(signInRequest.getEmail())
                .orElseThrow(() -> {
                    log.error("User with email: %s not found".formatted(signInRequest.getEmail()));
                    return new RuntimeException(
                            "User with email: %s not found".formatted(signInRequest.getEmail()));
                });
        if (signInRequest.getPassword().isBlank()) {
            log.error("Password is blank!");
            throw new RuntimeException("Email is blank!");
        }
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            log.error("Wrong password");
            throw new RuntimeException("Wrong password!");
        }
        log.info("Generation of a token for a registered user");
        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
