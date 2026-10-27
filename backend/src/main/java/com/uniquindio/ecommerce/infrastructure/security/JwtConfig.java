package com.uniquindio.ecommerce.infrastructure.security;


import com.nimbusds.jose.jwk.source.ImmutableSecret;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class JwtConfig {


    private final String jwtSecret = "modelos3d-clave-secreta-para-clase-de-seguridad-2026";



    @Bean

    //FABRICA EL TOKEN (utiliza en el login)
    public JwtEncoder jwtEncoder(){
        return new NimbusJwtEncoder(new ImmutableSecret<>(jwtSecret.getBytes()));

    }

    //NIMBUS JOSE + JWT
    @Bean
    //REVISA EL TOKEN ( en cada petición )
    public JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder
                // 256 bit
                .withSecretKey(new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256"))
                .build();

    }


    @Bean
    // El que me LEE los roles que trae el TOKEN
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
  
        JwtGrantedAuthoritiesConverter authorities = new JwtGrantedAuthoritiesConverter();
        authorities.setAuthoritiesClaimName("roles");
        authorities.setAuthorityPrefix("");

        //hasauth("ADMIN")

        //BEARER: PORTADOR JWT -


        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(authorities);
        return converter;
    }
}
