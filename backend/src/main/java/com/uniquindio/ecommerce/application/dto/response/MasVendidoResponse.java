package com.uniquindio.ecommerce.application.dto.response;

import com.uniquindio.ecommerce.domain.repository.ModeloVentas;

public record MasVendidoResponse(String modeloId, String titulo, long ventas) {

    public static MasVendidoResponse desde(ModeloVentas fila) {
        return new MasVendidoResponse(fila.modeloId(), fila.titulo(), fila.ventas());
    }
}