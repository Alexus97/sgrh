package com.sgrh.sgrh.modules.admin.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.admin.entity.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    
    // Busca por el número de habitación 
    List<Habitacion> findByNumero(Integer numero);
    
    // sucursalHotel (objeto) + IdSucursal (su llave primaria)
    // List<Habitacion> findBySucursalHotelIdSucursal(Integer idSucursal);
    
    //  estado (objeto) + idEstado (su llave primaria)
    List<Habitacion> findByEstadoIdEstado(Integer idEstado);

    // HU-1.2
    @Query("""
           SELECT h FROM Habitacion h 
           WHERE h.idHabitacion NOT IN (
               SELECT rh.habitacion.idHabitacion FROM ReservaHabitacion rh 
               JOIN rh.reserva r 
               WHERE (r.fechaEntrada < :fechaSalida AND r.fechaSalida > :fechaEntrada)
           ) 
           AND (:idSucursal IS NULL OR h.sucursalHotel.idSucursal = :idSucursal) 
           AND (:idTipo IS NULL OR h.tipoHabitacion.idTipo = :idTipo) 
           AND (:capacidad IS NULL OR h.capacidad >= :capacidad)
           """)
    List<Habitacion> findDisponiblesConFiltro(
            @Param("fechaEntrada") LocalDate fechaEntrada,
            @Param("fechaSalida") LocalDate fechaSalida,
            @Param("idSucursal") Integer idSucursal,
            @Param("idTipo") Integer idTipo,
            @Param("capacidad") Integer capacidad
    );


    // HU-1.2
    // Busca habitaciones por el ID de la sucursal y el ID de su estado (5 = Disponible)
    // List<Habitacion> findBySucursalHotelIdSucursalAndEstadoIdEstado(Integer idSucursal, Integer idEstado);

    // HU-1.2
    //  Recupera la totalidad de las habitaciones de la sucursal mapeando sus relaciones
    @Query("""
       SELECT h FROM Habitacion h 
       JOIN FETCH h.tipoHabitacion 
       JOIN FETCH h.sucursalHotel 
       JOIN FETCH h.estado 
       WHERE h.sucursalHotel.idSucursal = :idSucursal
       """)
    List<Habitacion> findBySucursalHotelIdSucursal(@Param("idSucursal") Integer idSucursal);
}