package com.sgrh.sgrh.modules.admin.service;

import java.util.List;

import com.sgrh.sgrh.modules.admin.dto.BusquedaHabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDetalleDTO;

public interface ImagenHabitacionService {

   

    /**
     * HU-2: Endpoint para validar la disponibilidad de habitaciones en un rango de fechas con filtrado dinámico..
     * Rol: Cliente
     */
    List<HabitacionDTO> buscarDisponiblesConFiltro(BusquedaHabitacionDTO filtros);


}
