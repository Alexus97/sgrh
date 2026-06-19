package com.sgrh.sgrh.modules.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.admin.entity.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    Optional<Servicio> findByNombre(String nombre);

    @Query("SELECT DISTINCT s FROM ConsumoServicio cs " +
            "JOIN cs.servicio s " +
            "JOIN cs.reserva r " +
            "JOIN ReservaHabitacion rh ON rh.reserva.idReserva = r.idReserva " +
            "JOIN rh.habitacion h " +
            "WHERE h.sucursalHotel.idSucursal = :idSucursal")
    List<Servicio> findServiciosBySucursalId(@Param("idSucursal") Integer idSucursal);
}
