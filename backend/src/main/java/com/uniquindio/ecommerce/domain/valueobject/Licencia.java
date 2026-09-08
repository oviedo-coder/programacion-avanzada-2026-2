package com.uniquindio.ecommerce.domain.valueobject;

public enum Licencia {
    PERSONAL(1),
    COMERCIAL(3),
    ILIMITADA(10);

    private final int factorPrecio;

    Licencia(int factorPrecio) {
        this.factorPrecio = factorPrecio;
    }

    public boolean permiteUsoComercial() {
        return this == COMERCIAL || this == ILIMITADA;
    }

    public int factorPrecio() {
        return factorPrecio;
    }
}
