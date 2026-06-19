package com.sgrh.sgrh.modules.admin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgrh.sgrh.modules.admin.entity.SucursalHotel;

@Repository
public interface SucursalHotelRepository extends JpaRepository<SucursalHotel, Integer> {
    Optional<SucursalHotel> findByNombre(String nombre);
}
