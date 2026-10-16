package com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity;

import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Esta clase se mapea a una tabla
@Table(name= "compras")
@Getter @Setter
@NoArgsConstructor
public class CompraEntity {

    //ddl-auto = validate
    //create-drop

    @Id
    @Column(length = 36)
    private String id;

    @Column(name="comprador_id", nullable = false, length = 50)
    private String compradorId;

    @Column(name="modelo_id", nullable = false, length = 50)
    private String modeloId;

    @Embedded
    private PrecioEmbeddable precio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoCompra estado;

    @Column(name="fecha_compra", nullable = false)
    private LocalDateTime fechaCompra;


}