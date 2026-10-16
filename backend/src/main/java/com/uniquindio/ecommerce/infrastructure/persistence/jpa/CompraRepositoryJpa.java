package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.mapper.CompraPersistenceMapper;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompraRepositoryJpa implements CompraRepository {

    private final CompraJpaDataRepository dataRepository;
    private final CompraPersistenceMapper mapper;

    @Override
    public Optional<Compra> obtenerPorId(String id) {
        return dataRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void guardar(Compra compra) {
        dataRepository.save(mapper.toEntity(compra));
    }

    @Override
    public boolean existeCompraCompletada(String compradorId, String modeloId) {
        return dataRepository.existsByCompradorIdAndModeloIdAndEstado(
                compradorId, modeloId, EstadoCompra.COMPLETADA);
    }

    @Override
    public List<Compra> obtenerPorCompradorId(String compradorId) {
        return dataRepository.findByCompradorIdOrderByFechaCompraDesc(compradorId).stream()
                .map(mapper::toDomain)
                .toList();
    }
}