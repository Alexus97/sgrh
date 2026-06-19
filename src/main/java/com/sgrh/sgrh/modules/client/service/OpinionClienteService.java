package com.sgrh.sgrh.modules.client.service;

import java.util.List;

import com.sgrh.sgrh.modules.client.dto.OpinionClienteDTO;

public interface OpinionClienteService {
    // Método que requiere el controlador (Para filtrar por el ID de la
    // Sucursal/Entidad que corresponda)
    List<OpinionClienteDTO> findBySucursalId(Integer sucursalId);

    // Otros métodos útiles que podrías necesitar basados en tu repositorio
    // List<OpinionClienteDTO> findByClienteId(Integer clienteId);

    // List<OpinionClienteDTO> findByReservaId(Integer reservaId);

}
