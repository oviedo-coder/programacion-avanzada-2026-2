package com.uniquindio.ecommerce.domain.entity;

import com.uniquindio.ecommerce.domain.valueobject.Precio;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;
import java.util.Objects;

public class Modelo3D {
    private final String id;
    private String titulo;
    private Precio precio;
    private boolean eliminado;

    private Modelo3D(String id, String titulo, Precio precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.eliminado = false;
    }

    public static Modelo3D publicar(String id, String titulo, Precio precio) {
        return new Modelo3D(id, titulo, precio);
    }

    public boolean estaEliminado() {
        return this.eliminado;
    }

    public void eliminarLogicamente() {
        if (this.eliminado) {
            throw new ReglaDominioException("El modelo ya está eliminado");
        }
        this.eliminado = true;
    }

    // Sin setters — el comportamiento que cambie el estado se agrega en la Guía 05

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo3D)) return false;
        Modelo3D otro = (Modelo3D) o;
        return id.equals(otro.id); // compara SOLO por id, nunca por título/precio
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // el hash también depende únicamente del id
    }
}
