package com.sgrh.sgrh.modules.admin.mapper;

import org.mapstruct.Mapper;

import com.sgrh.sgrh.modules.admin.dto.SucursalHotelDTO;
import com.sgrh.sgrh.modules.admin.entity.SucursalHotel;

@Mapper(componentModel = "spring")
public interface SucursalHotelMapper {
    SucursalHotelDTO toDTO(SucursalHotel entity);

    SucursalHotel toEntity(SucursalHotelDTO dto);
}
