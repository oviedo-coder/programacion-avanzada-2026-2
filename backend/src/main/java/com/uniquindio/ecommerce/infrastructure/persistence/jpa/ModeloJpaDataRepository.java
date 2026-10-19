package com.uniquindio.ecommerce.infrastructure.persistence.jpa;

import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.Modelo3DEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

interface ModeloJpaDataRepository extends JpaRepository <Modelo3DEntity, String> {

    List<Modelo3DEntity> findByEliminadoFalseOrderByTituloAsc();

    @Query("""
                SELECT m FROM Modelo3DEntity m
                WHERE m.eliminado = false
                AND LOWER(m.titulo) LIKE LOWER(CONCAT('%', :texto, '%' ))
                AND m.licencia IN (:licencias)
               
""")

    Page<Modelo3DEntity> buscar (@Param("texto") String texto,
                                 @Param("licencias")Collection<Licencia> licencias,
                                 Pageable pageable);



}
