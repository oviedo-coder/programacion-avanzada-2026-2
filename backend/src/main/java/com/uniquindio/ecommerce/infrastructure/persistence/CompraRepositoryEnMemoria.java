package com.uniquindio.ecommerce.infrastructure.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import org.springframework.stereotype.Repository;
import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;


// NoUniqueBeanDefinitionException
//@Repository
public class CompraRepositoryEnMemoria implements CompraRepository {

    private final Map<String, Compra> compras = new HashMap<>();

    @Override
    public Optional<Compra> obtenerPorId(String id) {
        return Optional.ofNullable(compras.get(id));
    }

    @Override
    public void guardar(Compra compra) {
        compras.put(compra.getId(), compra);
    }

    @Override
    public boolean existeCompraCompletada(String compradorId, String modeloId){

        return compras.values().stream()
                .anyMatch(c -> c.getCompradorId().equals(compradorId)
                        && c.getModeloId().equals(modeloId)
                        && c.getEstado() == EstadoCompra.COMPLETADA);
    }

    @Override
    public List<Compra> obtenerPorCompradorId(String compradorId){
        return compras.values().stream()
                .filter(c -> c.getCompradorId().equals(compradorId))
                .toList();
    }

}