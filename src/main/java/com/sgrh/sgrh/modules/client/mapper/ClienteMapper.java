package com.sgrh.sgrh.modules.client.mapper;

import com.sgrh.sgrh.modules.client.dto.ClienteDTO;
import com.sgrh.sgrh.modules.client.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente entity);
    Cliente toEntity(ClienteDTO dto);
}
