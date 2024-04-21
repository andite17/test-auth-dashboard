package com.app.muamalat.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterDto {
    @NotBlank(message = "Full Name is mandatory")
    public String fullName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    public String email;

    @NotBlank(message = "Password is mandatory")
    @Size(
            min = 8, max = 100,
            message= "Password should have a length between 8 and 100 characters.")
    public String password;
}
