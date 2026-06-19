package com.sgrh.sgrh.modules.admin.repository;

import com.sgrh.sgrh.modules.admin.entity.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {
    Optional<TipoHabitacion> findByDescripcion(String descripcion);
}
