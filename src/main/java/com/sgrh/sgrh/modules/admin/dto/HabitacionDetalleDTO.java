package com.sgrh.sgrh.modules.admin.dto;

import java.math.BigDecimal;
import java.util.List;

public record HabitacionDetalleDTO(
        Integer idHabitacion,
        Integer numero,
        Integer capacidad,
        BigDecimal precioNoche,
        // Información Extendida para la HU-3
        String tipoDescripcion,  // Guardará la descripción de TipoHabitacion
        Integer idSucursal,      // Pasamos solo el ID que sí existe con certeza
        Integer idEstado,        // Pasamos solo el ID que sí existe con certeza

        // Lista de rutas/URLs de las imágenes
        // Tu lista de imágenes simuladas o de la nueva entidad
        List<String> imagenesUrls ) {
}
