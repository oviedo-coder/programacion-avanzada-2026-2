package com.uniquindio.ecommerce.infrastructure.security;

import com.uniquindio.ecommerce.infrastructure.persistence.jpa.UsuarioJpaDataRepository;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.RolSeguridad;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuariosIniciales implements CommandLineRunner {

    private record Semilla(String id, String email, String clave, RolSeguridad rol) {}

    private final UsuarioJpaDataRepository repository;
    private final PasswordEncoder encoder;

    //admin123

    @Override
    public void run(String... args) {
        List<Semilla> semillas = List.of(
                new Semilla("admin", "admin@modelos3d.com", "admin123", RolSeguridad.ADMIN),
                new Semilla("ana", "ana@modelos3d.com", "ana123", RolSeguridad.USER),
                new Semilla("bruno", "bruno@modelos3d.com", "bruno123", RolSeguridad.USER),
                new Semilla("carla", "carla@modelos3d.com", "carla123", RolSeguridad.USER),
                new Semilla("diego", "diego@modelos3d.com", "diego123", RolSeguridad.USER),
                new Semilla("elena", "elena@modelos3d.com", "elena123", RolSeguridad.USER)
        );
        for (Semilla s : semillas) {
            repository.save(new UsuarioEntity(s.id(), s.email(), encoder.encode(s.clave()), s.rol()));
        }
    }
}