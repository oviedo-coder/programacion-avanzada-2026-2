package com.uniquindio.ecommerce.application.dto.response;

import com.uniquindio.ecommerce.domain.entity.Modelo3D;

public record ModeloResponse(
        String id,
        String titulo,
        double precio,
        String moneda,
        String licencia,
        boolean permiteUsoComercial
) {
    public static ModeloResponse desde(Modelo3D modelo) {
        return new ModeloResponse(
                modelo.getId(),
                modelo.getTitulo(),
                modelo.getPrecio().monto(),
                modelo.getPrecio().moneda(),
                modelo.getLicencia().name(),
                modelo.getLicencia().permiteUsoComercial());
    }
}