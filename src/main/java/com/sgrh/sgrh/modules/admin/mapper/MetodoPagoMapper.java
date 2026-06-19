package com.sgrh.sgrh.modules.admin.mapper;

import com.sgrh.sgrh.modules.admin.dto.MetodoPagoDTO;
import com.sgrh.sgrh.modules.admin.entity.MetodoPago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetodoPagoMapper {
    MetodoPagoDTO toDTO(MetodoPago entity);
    MetodoPago toEntity(MetodoPagoDTO dto);
}
