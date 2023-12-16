package com.example.demo.controller;

import com.example.demo.dto.request.auth.SignInRequest;
import com.example.demo.dto.request.auth.SignUpRequest;
import com.example.demo.dto.response.auth.AuthenticationResponse;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "This is sign-up method")
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return ResponseEntity.ok(userService.signUp(signUpRequest));
    }

    @Operation(summary = "This is sign-in method")
    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody @Valid SignInRequest authenticationRequest) {
        return ResponseEntity.ok(userService.signIn(authenticationRequest));
    }

}
