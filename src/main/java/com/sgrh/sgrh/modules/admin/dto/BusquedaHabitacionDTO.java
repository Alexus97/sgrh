package com.sgrh.sgrh.modules.admin.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public record BusquedaHabitacionDTO(
    @NotNull(message = "La fecha de entrada es obligatoria.")
    @FutureOrPresent(message = "La fecha de entrada debe ser el día de hoy o una fecha futura.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate fechaEntrada,
    
    @NotNull(message = "La fecha de salida es obligatoria.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate fechaSalida,
    
    Integer idSucursal,
    Integer idTipo,
    Integer capacidad) {
}
