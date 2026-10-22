package com.uniquindio.ecommerce.domain.entity;

import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;
import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import com.uniquindio.ecommerce.domain.valueobject.Precio;

import java.util.Objects;

/**
 * Raíz del agregado Modelo3D: una pieza imprimible publicada en el catálogo.
 * Es un agregado APARTE de Compra: la Compra solo guarda su id (Clase 5).
 */
public class Modelo3D {

    private final String id;
    private String titulo;
    private Precio precio;
    private final Licencia licencia;
    private boolean eliminado;

    private Modelo3D(String id, String titulo, Precio precio, Licencia licencia, boolean eliminado) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.licencia = licencia;
        this.eliminado = eliminado;
    }

    // La puerta de siempre (Clase 4): publica con licencia PERSONAL.
    public static Modelo3D publicar(String id, String titulo, Precio precio) {
        return publicar(id, titulo, precio, Licencia.PERSONAL);
    }

    // Nueva puerta: publica indicando la licencia. Valida antes de existir.
    public static Modelo3D publicar(String id, String titulo, Precio precio, Licencia licencia) {
        if (titulo == null || titulo.isBlank()) {
            throw new ReglaDominioException("El modelo debe tener título");
        }
        if (precio == null || licencia == null) {
            throw new ReglaDominioException("El modelo debe tener precio y licencia");
        }
        return new Modelo3D(id, titulo, precio, licencia, false);
    }

    // Solo para el adaptador de persistencia: "revive" un modelo que YA existía (no valida).
    public static Modelo3D reconstruir(String id, String titulo, Precio precio,
                                       Licencia licencia, boolean eliminado) {
        return new Modelo3D(id, titulo, precio, licencia, eliminado);
    }

    public void eliminarLogicamente() {
        if (eliminado) {
            throw new ReglaDominioException("El modelo ya está eliminado");
        }
        this.eliminado = true;
    }

    public boolean estaEliminado() { return eliminado; }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public Precio getPrecio() { return precio; }
    public Licencia getLicencia() { return licencia; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modelo3D)) return false;
        Modelo3D otro = (Modelo3D) o;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}