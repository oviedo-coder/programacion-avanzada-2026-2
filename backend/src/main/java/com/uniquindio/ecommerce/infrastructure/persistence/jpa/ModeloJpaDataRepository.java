package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.Modelo3DEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uniquindio.ecommerce.domain.repository.ModeloVentas;
import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;

import java.util.Collection;
import java.util.List;

interface ModeloJpaDataRepository extends JpaRepository <Modelo3DEntity, String> {

    List<Modelo3DEntity> findByEliminadoFalseOrderByTituloAsc();

    @Query("""
        SELECT m FROM Modelo3DEntity m
        WHERE m.eliminado  = false
        AND LOWER(m.titulo) LIKE LOWER(CONCAT('%', :texto, '%'))
        AND m.licencia IN (:licencias)
            """)

    Page<Modelo3DEntity> buscar (@Param("texto") String texto,
                                    @Param("licencias") Collection<Licencia> licencias,
                                 Pageable pageable);


    @Query("""
            SELECT new com.uniquindio.ecommerce.domain.repository.ModeloVentas(m.id, m.titulo, COUNT(c))
            FROM Modelo3DEntity m
            JOIN CompraEntity c ON c.modeloId = m.id
            WHERE c.estado = :estado
            GROUP BY m.id, m.titulo
            ORDER BY COUNT(c) DESC, m.titulo ASC
            """)
    List<ModeloVentas> masVendidos(@Param("estado") EstadoCompra estado, Pageable pageable);


}

