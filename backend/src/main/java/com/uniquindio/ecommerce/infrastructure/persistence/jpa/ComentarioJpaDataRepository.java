package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.ComentarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface ComentarioJpaDataRepository extends JpaRepository<ComentarioEntity, String> {
}