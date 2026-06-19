package com.sgrh.sgrh.modules.admin.mapper;

import com.sgrh.sgrh.modules.admin.dto.ServicioDTO;
import com.sgrh.sgrh.modules.admin.entity.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicioMapper {
    ServicioDTO toDTO(Servicio entity);
    Servicio toEntity(ServicioDTO dto);
}
