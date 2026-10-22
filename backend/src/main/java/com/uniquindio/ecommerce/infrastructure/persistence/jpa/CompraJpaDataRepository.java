package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.CompraEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface CompraJpaDataRepository extends JpaRepository<CompraEntity, String> {

    List<CompraEntity> findByCompradorIdOrderByFechaCompraDesc(String compradorId);

    boolean existsByCompradorIdAndModeloIdAndEstado(
            String compradorId, String modeloId, EstadoCompra estado);

}