package com.example.demo.service;

import com.example.demo.dto.request.auth.AuthenticationRequest;
import com.example.demo.dto.request.auth.SignUpRequest;
import com.example.demo.dto.response.auth.AuthenticationResponse;

public interface UserService {
    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(AuthenticationRequest authenticationRequest);

}
