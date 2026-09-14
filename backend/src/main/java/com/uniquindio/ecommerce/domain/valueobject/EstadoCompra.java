package com.uniquindio.ecommerce.domain.valueobject;

public enum EstadoCompra {

    PENDIENTE,
    COMPLETADA,
    REEMBOLSADA;


    // El conocimiento de las transiciones válidas vive AQUÍ, no en ifs
    // dispersos por el código del agregado.

    public boolean puedeTransicionarA(EstadoCompra siguiente) {
        return switch (this) {
            case PENDIENTE   -> siguiente == COMPLETADA;
            case COMPLETADA  -> siguiente == REEMBOLSADA;
            case REEMBOLSADA -> false; // estado final: no admite salida
        };
    }

    public boolean esFinal() {
        return this == REEMBOLSADA;
    }
}