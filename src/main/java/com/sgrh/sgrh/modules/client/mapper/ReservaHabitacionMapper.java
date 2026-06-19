package com.sgrh.sgrh.modules.client.mapper;

import com.sgrh.sgrh.modules.client.dto.ReservaHabitacionDTO;
import com.sgrh.sgrh.modules.client.entity.ReservaHabitacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaHabitacionMapper {
    @Mapping(target = "idReserva", source = "reserva.idReserva")
    @Mapping(target = "idHabitacion", source = "habitacion.idHabitacion")
    ReservaHabitacionDTO toDTO(ReservaHabitacion entity);

    @Mapping(target = "idReservaHabitacion", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "habitacion", ignore = true)
    ReservaHabitacion toEntity(ReservaHabitacionDTO dto);
}
