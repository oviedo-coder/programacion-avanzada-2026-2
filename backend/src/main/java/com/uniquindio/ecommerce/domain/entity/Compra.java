package com.uniquindio.ecommerce.domain.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;
import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;
import com.uniquindio.ecommerce.domain.valueobject.Precio;

/**
 * Raíz del agregado Compra.
 *
 * Invariantes que garantiza:
 *  - toda compra nace en estado PENDIENTE;
 *  - el precio queda congelado al momento de comprar (no cambia aunque el
 *    modelo suba de precio después);
 *  - solo se transita entre estados permitidos por el ciclo de vida;
 *  - una compra reembolsada no admite ninguna modificación.
 */
public class Compra {

    private final String id;
    private final String modeloId;      // solo el id: Modelo3D es OTRO agregado
    private final String compradorId;   // solo el id: Usuario es OTRO agregado
    private final Precio precioCongelado;  // el precio "de una foto", no cambia después
    private final LocalDateTime fechaCompra;
    private EstadoCompra estado;

    // Constructor privado: nadie crea una Compra sin pasar por realizar(...)
    private Compra(String id, String modeloId, String compradorId, Precio precioCongelado) {
        this.id = id;
        this.modeloId = modeloId;
        this.compradorId = compradorId;
        this.precioCongelado = precioCongelado;
        this.fechaCompra = LocalDateTime.now();
        this.estado = EstadoCompra.PENDIENTE; // toda compra nace Pendiente, siempre
    }

    // Único punto de entrada para crear una Compra: valida ANTES de existir
    public static Compra realizar(String id, String modeloId, String compradorId, Precio precioActualDelModelo) {
        if (modeloId == null || compradorId == null) {
            throw new ReglaDominioException("La compra debe indicar modelo y comprador");
        }
        if (precioActualDelModelo == null) {
            throw new ReglaDominioException("La compra debe tener un precio válido");
        }
        return new Compra(id, modeloId, compradorId, precioActualDelModelo);
    }

    // ---------- Comportamiento del negocio ----------
    // Cada método valida PRIMERO, cambia el estado DESPUÉS — nunca al revés.

    public void confirmar() {
        verificarQueNoEsteReembolsada();
        verificarTransicion(EstadoCompra.COMPLETADA);
        this.estado = EstadoCompra.COMPLETADA;
    }

    public void solicitarReembolso(String motivo) {
        verificarQueNoEsteReembolsada();
        if (this.estado != EstadoCompra.COMPLETADA) {
            throw new ReglaDominioException("Solo se puede reembolsar una compra completada");
        }
        if (motivo == null || motivo.isBlank()) {
            throw new ReglaDominioException("El reembolso exige indicar un motivo");
        }
        verificarTransicion(EstadoCompra.REEMBOLSADA);
        this.estado = EstadoCompra.REEMBOLSADA;
    }

    // ---------- Verificaciones internas ----------
    // Privadas a propósito: nadie desde afuera puede saltárselas.

    private void verificarQueNoEsteReembolsada() {
        if (this.estado.esFinal()) {
            throw new ReglaDominioException("Una compra reembolsada no puede modificarse");
        }
    }

    private void verificarTransicion(EstadoCompra siguiente) {
        if (!this.estado.puedeTransicionarA(siguiente)) {
            throw new ReglaDominioException("No se puede pasar de " + this.estado + " a " + siguiente);
        }
    }

    // ---------- Consultas ----------
    // Sin setters: solo lectura hacia afuera.

    public EstadoCompra getEstado() {
        return estado;
    }

    public Precio getPrecioCongelado() {
        return precioCongelado;
    }

    // equals/hashCode por id: dos Compra son "la misma" solo si comparten id,
    // sin importar si el estado cambió con el tiempo (a diferencia de Precio,
    // que es un Value Object y compara TODOS sus campos).
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compra otra)) return false;
        return id.equals(otra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}