package com.sgrh.sgrh.modules.admin.service;

import java.util.List;
import com.sgrh.sgrh.modules.admin.dto.TipoHabitacionDTO;

public interface TipoHabitacionService {
    TipoHabitacionDTO crearTipoHabitacion(TipoHabitacionDTO tipoHabitacionDTO);

    TipoHabitacionDTO obtenerTipoHabitacionById(Integer idTipo);

    List<TipoHabitacionDTO> obtenerTodos();

    TipoHabitacionDTO actualizarTipoHabitacion(Integer idTipo, TipoHabitacionDTO tipoHabitacionDTO);

    void eliminarTipoHabitacion(Integer idTipo);
}