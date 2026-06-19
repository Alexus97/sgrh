package com.sgrh.sgrh.modules.admin.mapper;

import com.sgrh.sgrh.modules.admin.dto.EstadoDTO;
import com.sgrh.sgrh.modules.admin.entity.Estado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
    EstadoDTO toDTO(Estado entity);
    Estado toEntity(EstadoDTO dto);
}
