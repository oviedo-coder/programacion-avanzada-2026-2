package com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comentarios")
@Getter @Setter
@NoArgsConstructor
public class ComentarioEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "comprador_id", nullable = false, length = 50)
    private String compradorId;

    @Column(name = "modelo_id", nullable = false, length = 50)
    private String modeloId;

    @Column(nullable = false, length = 500)
    private String texto;

}