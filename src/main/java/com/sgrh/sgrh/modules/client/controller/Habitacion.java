package com.sgrh.sgrh.modules.client.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgrh.sgrh.modules.admin.dto.BusquedaHabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDTO;
import com.sgrh.sgrh.modules.admin.service.HabitacionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/habitacion")
@RequiredArgsConstructor
public class Habitacion {

    private final HabitacionService habitacionService;




    /**
     * HU-2: Endpoint para Obtener y validar la disponibilidad de habitaciones en un rango de fechas con filtrado dinámico.
     */
    @GetMapping("/busqueda-disponible")
    public ResponseEntity<List<HabitacionDTO>> buscarHabitacionesDisponibles(@Valid BusquedaHabitacionDTO filtros) {
        var habitaciones = habitacionService.buscarDisponiblesConFiltro(filtros);
        
        if (habitaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(habitaciones);
    }

}
