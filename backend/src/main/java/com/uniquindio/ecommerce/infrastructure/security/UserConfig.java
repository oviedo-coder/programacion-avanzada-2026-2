package com.uniquindio.ecommerce.infrastructure.security;

import com.uniquindio.ecommerce.infrastructure.persistence.jpa.UsuarioJpaDataRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(UsuarioJpaDataRepository repository) {
        return email -> repository.findByEmail(email)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
    }
}