package com.sgrh.sgrh.modules.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.client.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // List<Reserva> findByClienteIdCliente(Integer idCliente);
    // List<Reserva> findByFechaEntradaAndFechaSalida(LocalDate fechaEntrada, LocalDate fechaSalida);
    // List<Reserva> findByEstadoReservaIdEstado(Integer idEstado);
}
