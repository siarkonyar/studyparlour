package com.studyparlour.studyparlour.config.abstracts;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public interface SecurityConfig {
    public PasswordEncoder passwordEncoder();
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception;
}
