package com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PrecioEmbeddable {

    @Column(name= "precio_monto", nullable = false)
    private double monto;

    @Column(name= "precio_moneda", nullable = false, length = 3)
    private String moneda;

}