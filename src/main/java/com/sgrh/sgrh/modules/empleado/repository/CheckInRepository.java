package com.sgrh.sgrh.modules.empleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.empleado.entity.CheckIn;

import java.util.List;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Integer> {
    List<CheckIn> findByReservaIdReserva(Integer idReserva);
    List<CheckIn> findByEmpleadoIdEmpleado(Integer idEmpleado);
}
