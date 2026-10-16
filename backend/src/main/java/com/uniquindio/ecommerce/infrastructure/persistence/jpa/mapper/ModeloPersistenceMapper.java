package com.uniquindio.ecommerce.infrastructure.persistence.jpa.mapper;

import com.uniquindio.ecommerce.domain.entity.Modelo3D;
import com.uniquindio.ecommerce.domain.valueobject.Precio;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.Modelo3DEntity;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.PrecioEmbeddable;
import org.springframework.stereotype.Component;

@Component
public class ModeloPersistenceMapper {

    public Modelo3D toDomain(Modelo3DEntity entity) {
        return Modelo3D.reconstruir(
                entity.getId(),
                entity.getTitulo(),
                new Precio(entity.getPrecio().getMonto(), entity.getPrecio().getMoneda()),
                entity.getLicencia(),
                entity.isEliminado());
    }

    public Modelo3DEntity toEntity(Modelo3D modelo) {
        Modelo3DEntity entity = new Modelo3DEntity();
        entity.setId(modelo.getId());
        entity.setTitulo(modelo.getTitulo());
        entity.setPrecio(new PrecioEmbeddable(modelo.getPrecio().monto(), modelo.getPrecio().moneda()));
        entity.setLicencia(modelo.getLicencia());
        entity.setEliminado(modelo.estaEliminado());
        return entity;
    }
}