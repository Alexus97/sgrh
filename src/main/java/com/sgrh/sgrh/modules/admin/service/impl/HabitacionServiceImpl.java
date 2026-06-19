package com.sgrh.sgrh.modules.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgrh.sgrh.modules.admin.dto.BusquedaHabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDetalleDTO;
import com.sgrh.sgrh.modules.admin.entity.Habitacion;
import com.sgrh.sgrh.modules.admin.entity.ImagenHabitacion;
import com.sgrh.sgrh.modules.admin.mapper.HabitacionMapper;
import com.sgrh.sgrh.modules.admin.repository.HabitacionRepository;
import com.sgrh.sgrh.modules.admin.repository.ImagenHabitacionRepository;
import com.sgrh.sgrh.modules.admin.service.HabitacionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class HabitacionServiceImpl implements  HabitacionService {

    private final HabitacionRepository habitacionRepository;
    // private final SucursalHotelRepository sucursalHotelRepository;
    // private final EstadoRepository estadoRepository;
    private final HabitacionMapper habitacionMapper;
    // private final TipoHabitacionMapper tipoHabitacionMapper;
    // private final TipoHabitacionRepository tipoHabitacionRepository;
    private final ImagenHabitacionRepository imagenHabitacionRepository;



    @Override
    @Transactional(readOnly = true)
    public HabitacionDetalleDTO obtenerDetallePorId(Integer id) {

        // 1. Recuperar la habitación de la Base de Datos
        Habitacion habitacion = habitacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la habitación con ID: " + id));

        // 2. Recuperar la lista de imágenes vinculadas a su Tipo de Habitación
        Integer idTipo = habitacion.getTipoHabitacion().getIdTipo();
        List<ImagenHabitacion> imagenes = imagenHabitacionRepository.findByTipoHabitacionIdTipo(idTipo);

        // 3. Utilizar la función del Mapper para transformar los datos combinados al Record DTO
        return habitacionMapper.toDetalleDTO(habitacion, imagenes);

    }


    /**
     * HU-2: Endpoint para valida la disponibilidad de habitaciones en un rango de fechas con filtrado dinámico..
     * Rol: Cliente
     */
    @Override
    @Transactional(readOnly = true)
    public List<HabitacionDTO> buscarDisponiblesConFiltro(BusquedaHabitacionDTO filtros) {
        var habitacionesEntidad = habitacionRepository.findDisponiblesConFiltro(
                filtros.fechaEntrada(),
                filtros.fechaSalida(),
                filtros.idSucursal(),
                filtros.idTipo(),
                filtros.capacidad()
        );

        return habitacionesEntidad.stream()
                .map(habitacionMapper::toDTO)
                .toList(); // .toList() produce colecciones inmutables en Java 16+
    }


    /**
     * HU-1.2: Endpoint para Listar las habitaciones y tipos de habitaciones disponibles en esa sucursal.
     * Rol: Cliente
     */

    // @Override
    // @Transactional(readOnly = true)
    // public List<HabitacionDTO> obtenerHabitacionesDisponiblesPorSucursal(Integer idSucursal) { // ◄ Cambiado a List<HabitacionDTO>
    //     // 1. Primero listamos TODAS las habitaciones de la sucursal
    //     var todasLasHabitaciones = habitacionRepository.findBySucursalHotelIdSucursal(idSucursal);

    //     // 2. Filtramos para obtener las que están disponibles (idEstado == 1)
    //     // 3. Mapeamos al DTO simple (toDTO) requerido por la interfaz
    //     return todasLasHabitaciones.stream()
    //             .filter(habitacion -> habitacion.getEstado() != null && habitacion.getEstado().getIdEstado() == 1)
    //             .map(habitacionMapper::toDTO) // ◄ Cambiado a toDTO para resolver la incompatibilidad
    //             .toList();
    // }



    @Override
    @Transactional(readOnly = true)
    public List<HabitacionDetalleDTO> obtenerHabitacionesDisponiblesPorSucursal(Integer idSucursal) {
        // 1. Primero listamos TODAS las habitaciones de la sucursal
        var todasLasHabitaciones = habitacionRepository.findBySucursalHotelIdSucursal(idSucursal);

        // 2. Filtramos para obtener solo las que están disponibles (idEstado == 1)
        // 3. Mapeamos a HabitacionDetalleDTO inyectando sus imágenes correspondientes
        return todasLasHabitaciones.stream()
                .filter(habitacion -> habitacion.getEstado() != null && habitacion.getEstado().getIdEstado() == 1)
                .map(habitacion -> {
                    // Buscamos las imágenes asociadas al tipo de habitación
                    Integer idTipo = habitacion.getTipoHabitacion().getIdTipo();
                    List<ImagenHabitacion> imagenes = imagenHabitacionRepository.findByTipoHabitacionIdTipo(idTipo);
                    
                    // El mapper se encarga de unirlos en un solo objeto detallado
                    return habitacionMapper.toDetalleDTO(habitacion, imagenes);
                })
                .toList();
    }

   // Asegúrate de tener este método aquí abajo para que compile la interfaz

   // ==========================================
    // MÉTODOS OBLIGATORIOS PARA QUE MAVEN COMPILE
    // ==========================================

    @Override
    public HabitacionDTO crearHabitacion(HabitacionDTO habitacionDTO) {
        // Método vacío temporal para cumplir el contrato
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public HabitacionDTO obtenerHabitacionById(Integer idHabitacion) {
        // Método vacío temporal para cumplir el contrato
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<HabitacionDTO> obtenerTodas() {
        // Método vacío temporal para cumplir el contrato
        return List.of();
    }

    @Override
    public HabitacionDTO actualizarHabitacion(Integer idHabitacion, HabitacionDTO habitacionDTO) {
        // Método vacío temporal para cumplir el contrato
        return null;
    }

    @Override
    public void eliminarHabitacion(Integer idHabitacion) {
        // Método vacío temporal para cumplir el contrato
        habitacionRepository.deleteById(idHabitacion);
    }
   
} 