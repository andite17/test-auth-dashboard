package com.app.muamalat.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;
    private long expiresIn;
}
