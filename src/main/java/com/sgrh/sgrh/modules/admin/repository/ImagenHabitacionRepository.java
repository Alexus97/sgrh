package com.sgrh.sgrh.modules.admin.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.admin.entity.ImagenHabitacion;

@Repository
public interface ImagenHabitacionRepository extends JpaRepository<ImagenHabitacion, Integer> {
    // Busca las imágenes por el ID de la relación con TipoHabitacion
    List<ImagenHabitacion> findByTipoHabitacionIdTipo(Integer idTipo);

}


