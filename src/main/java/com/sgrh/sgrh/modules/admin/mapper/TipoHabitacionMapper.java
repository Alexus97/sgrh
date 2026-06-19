package com.sgrh.sgrh.modules.admin.mapper;

import com.sgrh.sgrh.modules.admin.dto.TipoHabitacionDTO;
import com.sgrh.sgrh.modules.admin.entity.TipoHabitacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoHabitacionMapper {
    // TipoHabitacionDTO toDTO(TipoHabitacion entity);
    // TipoHabitacion toEntity(TipoHabitacionDTO dto);

    @Mapping(source = "idTipo", target = "idTipo")
    TipoHabitacionDTO toDTO(TipoHabitacion entity);

    @Mapping(source = "idTipo", target = "idTipo")
    TipoHabitacion toEntity(TipoHabitacionDTO dto);
}
