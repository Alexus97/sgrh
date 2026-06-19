package com.sgrh.sgrh.modules.empleado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.empleado.entity.AsignacionRol;

import java.util.List;

@Repository
public interface AsignacionRolRepository extends JpaRepository<AsignacionRol, Integer> {
    List<AsignacionRol> findByEmpleadoIdEmpleado(Integer idEmpleado);
    List<AsignacionRol> findByRolIdRol(Integer idRol);
}
