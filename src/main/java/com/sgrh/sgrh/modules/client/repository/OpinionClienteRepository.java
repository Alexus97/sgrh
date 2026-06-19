package com.sgrh.sgrh.modules.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.client.entity.OpinionCliente;

@Repository
public interface OpinionClienteRepository extends JpaRepository<OpinionCliente, Integer> {
    List<OpinionCliente> findByClienteIdCliente(Integer idCliente);

    List<OpinionCliente> findByReservaIdReserva(Integer idReserva);

    // Consulta JPQL para navegar por la tabla intermedia ReservaHabitacion hasta la Sucursal
    // Consulta JPQL navegando por: OpinionCliente -> Reserva -> ReservaHabitacion -> Habitacion -> SucursalHotel
    @Query("SELECT DISTINCT o FROM OpinionCliente o " +
           "JOIN o.reserva r " +
           "JOIN ReservaHabitacion rh ON rh.reserva = r " +
           "WHERE rh.habitacion.sucursalHotel.idSucursal = :idSucursal")
    List<OpinionCliente> findBySucursalId(@Param("idSucursal") Integer idSucursal);
}
