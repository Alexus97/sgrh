package com.sgrh.sgrh.modules.admin.mapper;

import com.sgrh.sgrh.modules.admin.dto.PromocionDTO;
import com.sgrh.sgrh.modules.admin.entity.Promocion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromocionMapper {
    PromocionDTO toDTO(Promocion entity);
    Promocion toEntity(PromocionDTO dto);
}
