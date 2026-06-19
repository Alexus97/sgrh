package com.sgrh.sgrh.modules.admin.mapper;

import com.sgrh.sgrh.modules.admin.dto.RolDTO;
import com.sgrh.sgrh.modules.admin.entity.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO toDTO(Rol entity);
    Rol toEntity(RolDTO dto);
}
