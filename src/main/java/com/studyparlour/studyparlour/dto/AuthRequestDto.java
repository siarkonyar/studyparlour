package com.studyparlour.studyparlour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
