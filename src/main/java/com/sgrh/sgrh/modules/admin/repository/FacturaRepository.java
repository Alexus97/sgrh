package com.sgrh.sgrh.modules.admin.repository;

import com.sgrh.sgrh.modules.admin.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    List<Factura> findByReservaIdReserva(Integer idReserva);
    List<Factura> findByFechaEmision(LocalDate fechaEmision);
}
