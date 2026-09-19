package com.uniquindio.ecommerce.infrastructure.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;

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
}