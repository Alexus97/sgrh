package com.sgrh.sgrh.modules.admin.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record FacturaDTO(
        Integer idFactura,
        @NotNull(message = "La reserva no puede ser nula")
        Integer idReserva,
        @NotNull(message = "La fecha de emisión no puede ser nula")
        LocalDate fechaEmision,
        @NotNull(message = "El total no puede ser nulo")
        @DecimalMin(value = "0.0", inclusive = false, message = "El total debe ser mayor a 0")
        BigDecimal total
) {
}
