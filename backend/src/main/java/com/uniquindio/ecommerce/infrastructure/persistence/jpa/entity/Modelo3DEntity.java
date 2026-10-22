package com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity;

import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "modelos3d")
@Getter @Setter
@NoArgsConstructor
public class Modelo3DEntity {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Embedded
    private PrecioEmbeddable precio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Licencia licencia;

    @Column(nullable = false)
    private boolean eliminado;
}