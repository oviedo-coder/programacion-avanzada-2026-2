package com.uniquindio.ecommerce.infrastructure.rest;

import com.uniquindio.ecommerce.application.dto.request.LoginRequest;
import com.uniquindio.ecommerce.application.dto.response.TokenResponse;
import com.uniquindio.ecommerce.infrastructure.security.AutenticacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AutenticacionService autenticacionService;

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody LoginRequest request) {
        return autenticacionService.login(request);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> credencialesInvalidas() {
        return Map.of("error", "Usuario o contraseña incorrectos");
    }
}