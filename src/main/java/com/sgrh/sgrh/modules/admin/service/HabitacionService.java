package com.sgrh.sgrh.modules.admin.service;

import java.util.List;

import com.sgrh.sgrh.modules.admin.dto.BusquedaHabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDetalleDTO;

public interface HabitacionService {
    HabitacionDTO crearHabitacion(HabitacionDTO habitacionDTO);
    HabitacionDTO obtenerHabitacionById(Integer idHabitacion);
    List<HabitacionDTO> obtenerTodas();
    HabitacionDTO actualizarHabitacion(Integer idHabitacion, HabitacionDTO habitacionDTO);
    void eliminarHabitacion(Integer idHabitacion);

    //HU-2: List<HabitacionDTO> buscarDisponiblesConFiltro(BusquedaHabitacionDTO filtros);
    List<HabitacionDTO> buscarDisponiblesConFiltro(BusquedaHabitacionDTO filtros);

    //HU-1.2:
    List<HabitacionDetalleDTO> obtenerHabitacionesDisponiblesPorSucursal(Integer idSucursal);
    // List<HabitacionDetalleDTO> listarHabitacionesDisponiblesPorSucursal(Integer idSucursal);

     // service HU-3: Retornar toda la información extendida e imágenes de una habitación concreta seleccionada por el cliente.
    HabitacionDetalleDTO obtenerDetallePorId( Integer id);



    
    
    


}