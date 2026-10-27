package com.uniquindio.ecommerce.infrastructure.security;

import com.uniquindio.ecommerce.application.dto.request.LoginRequest;
import com.uniquindio.ecommerce.application.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutenticacionService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Value("${jwt.expiry}")
    private long minutosDeVida;

    public TokenResponse login(LoginRequest request) {
        Authentication autenticacion = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        CustomUserDetails detalles = (CustomUserDetails) autenticacion.getPrincipal();

        List<String> roles = List.of(detalles.usuario().getRol().name());

        Instant ahora = Instant.now();
        Instant expira = ahora.plus(minutosDeVida, ChronoUnit.MINUTES);

        String token = jwtTokenProvider.generar(
                autenticacion.getName(), detalles.usuario().getId(), roles, ahora, expira);

        return new TokenResponse(token, "Bearer", expira, roles);
    }
}

