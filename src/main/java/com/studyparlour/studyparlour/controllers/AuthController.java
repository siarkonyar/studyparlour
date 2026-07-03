package com.studyparlour.studyparlour.controllers;

import com.studyparlour.studyparlour.business.abstracts.TokenService;
import com.studyparlour.studyparlour.business.abstracts.UserService;
import com.studyparlour.studyparlour.config.SecurityConfig;
import com.studyparlour.studyparlour.dto.AuthRequestDto;
import com.studyparlour.studyparlour.dto.RegisterRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.time.Duration;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    @PostMapping("/register")
    public ResponseEntity<String> register (@Valid @RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody AuthRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        String token = tokenService.generateToken(authentication);

        ResponseCookie cookie = buildAccessTokenCookie(token, Duration.ofMillis(expirationMs));

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(){
        ResponseCookie cookie = buildAccessTokenCookie("", Duration.ZERO);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }


    public ResponseCookie buildAccessTokenCookie(String value, Duration maxAge){
        return ResponseCookie.from(SecurityConfig.ACCESS_TOKEN_COOKIE, value)
                .httpOnly(true)
                .secure(false)     // TODO: true in production (HTTPS only)
                .path("/")
                .maxAge(maxAge)
                .sameSite("Lax")
                .build();
    }
}
