package com.sgrh.sgrh.modules.empleado.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record CheckOutDTO(
        Integer idCheckOut,
        @NotNull(message = "La reserva no puede ser nula")
        Integer idReserva,
        @NotNull(message = "El empleado no puede ser nulo")
        Integer idEmpleado,
        @NotNull(message = "La fecha y hora no puede ser nula")
        LocalDateTime fechaHora
) {
}
