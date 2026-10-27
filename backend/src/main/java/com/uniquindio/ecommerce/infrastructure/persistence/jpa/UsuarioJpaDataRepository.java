package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJpaDataRepository extends JpaRepository<UsuarioEntity, String> {

    Optional<UsuarioEntity> findByEmail(String email);
}