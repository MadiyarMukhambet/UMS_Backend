package com.unims.dto;

import com.unims.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
    private String name;
    private String email;
}
