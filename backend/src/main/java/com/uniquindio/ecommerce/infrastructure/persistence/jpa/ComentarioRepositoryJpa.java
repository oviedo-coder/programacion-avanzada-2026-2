package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.domain.entity.Comentario;
import com.uniquindio.ecommerce.domain.repository.ComentarioRepository;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.ComentarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ComentarioRepositoryJpa implements ComentarioRepository {

    private final ComentarioJpaDataRepository dataRepository;

    @Override
    public void guardar(Comentario comentario) {
        ComentarioEntity entity = new ComentarioEntity();
        entity.setId(comentario.getId());
        entity.setCompradorId(comentario.getCompradorId());
        entity.setModeloId(comentario.getModeloId());
        entity.setTexto(comentario.getTexto());
        dataRepository.save(entity);
    }
}