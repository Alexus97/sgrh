package com.sgrh.sgrh.modules.admin.dto;

import jakarta.validation.constraints.NotNull;

public record ServicioPromocionDTO(
        @NotNull(message = "El servicio no puede ser nulo")
        Integer idServicio,
        @NotNull(message = "La promoción no puede ser nula")
        Integer idPromocion
) {
}
