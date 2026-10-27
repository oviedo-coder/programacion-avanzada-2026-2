package com.uniquindio.ecommerce.infrastructure.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtEncoder encoder;

    public String generar(String email, String usuarioId, Collection<String> roles,
                          Instant emitidoEn, Instant expiraEn) {


        // el HEADER: dice con que formula se firma
        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();


        // PAYLOAD: lo que dice la manilla
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("modelo3d-api")
                .issuedAt(emitidoEn)
                .expiresAt(expiraEn)
                .subject(email)
                .claim("uid", usuarioId)
                .claim("roles", roles)
                .build();


        // sella: calcular la firma con secret key - > header.payload.firma
        return encoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

}
