package com.sgrh.sgrh.modules.admin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TipoHabitacionDTO(
        @JsonIgnore
        Integer idTipo,
        @NotBlank(message = "La descripción no puede estar vacía")
        @Size(max = 50, message = "La descripción no puede exceder 50 caracteres")
        String descripcion,
        @NotNull(message = "El precio base no puede ser nulo")
        @DecimalMin(value = "0.0", inclusive = false, message = "El precio base debe ser mayor a 0")
        BigDecimal precioBase
) {
}
