package com.uniquindio.ecommerce.infrastructure.persistence;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.uniquindio.ecommerce.domain.entity.Comentario;
import com.uniquindio.ecommerce.domain.repository.ComentarioRepository;

//@Repository
public class ComentarioRepositoryEnMemoria implements ComentarioRepository {

    private final Map<String, Comentario> comentarios = new HashMap<>();

    @Override
    public void guardar(Comentario comentario) {
        comentarios.put(comentario.getId(), comentario);
    }


}