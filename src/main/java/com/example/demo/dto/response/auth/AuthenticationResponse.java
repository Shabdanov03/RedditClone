package com.example.demo.dto.response.auth;

import com.example.demo.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class AuthenticationResponse {
    public String token;
    public String email;
    public Role role;

}
