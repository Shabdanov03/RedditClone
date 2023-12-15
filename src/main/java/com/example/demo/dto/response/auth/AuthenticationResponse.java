package com.example.demo.dto.response.auth;

import com.example.demo.enums.Role;
import lombok.Builder;

@Builder
public class AuthenticationResponse {
    public String token;
    public String email;
    public Role role;

}
