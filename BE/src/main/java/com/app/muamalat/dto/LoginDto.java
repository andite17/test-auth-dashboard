package com.app.muamalat.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not valid")
    public String email;
    @Size(
            min = 8, max = 100,
            message= "Password should have a length between 8 and 100 characters.")
    @NotBlank(message = "Field emali is mandatory")
    public String password;
}
