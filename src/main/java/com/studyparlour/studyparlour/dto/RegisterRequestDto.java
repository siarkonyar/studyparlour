package com.studyparlour.studyparlour.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDto {
    @NotBlank @Size(min=4, max = 20)
    private String username;

    @Email @NotBlank
    private String email;

    @NotBlank @Size(min = 8, max = 50)
    private String password;
}
