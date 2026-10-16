package com.uniquindio.ecommerce.domain.entity;

import java.util.Objects;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;

public class Comentario {

    private final String id;
    private final String compradorId;
    private final String modeloId;
    private final String texto;

    private Comentario(String id, String compradorId, String modeloId, String texto) {
        this.id = id;
        this.compradorId = compradorId;
        this.modeloId = modeloId;
        this.texto = texto;
    }

    public static Comentario crear(String compradorId, String modeloId, String texto) {
        if (texto == null || texto.isBlank()) {
            throw new ReglaDominioException("El comentario no puede estar vacío");
        }
        String id = java.util.UUID.randomUUID().toString();
        return new Comentario(id, compradorId, modeloId, texto);
    }

    public String getId() { return id; }
    public String getCompradorId() { return compradorId; }
    public String getModeloId() { return modeloId; }
    public String getTexto() { return texto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comentario otro)) return false;
        return id.equals(otro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}