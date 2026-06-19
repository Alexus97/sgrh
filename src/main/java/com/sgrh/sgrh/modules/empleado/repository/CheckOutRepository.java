package com.sgrh.sgrh.modules.empleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.empleado.entity.CheckOut;

import java.util.List;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOut, Integer> {
    List<CheckOut> findByReservaIdReserva(Integer idReserva);
    List<CheckOut> findByEmpleadoIdEmpleado(Integer idEmpleado);
}
