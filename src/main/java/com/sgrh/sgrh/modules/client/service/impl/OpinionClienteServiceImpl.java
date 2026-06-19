package com.sgrh.sgrh.modules.client.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgrh.sgrh.modules.client.dto.OpinionClienteDTO;
import com.sgrh.sgrh.modules.client.entity.OpinionCliente;
import com.sgrh.sgrh.modules.client.mapper.OpinionClienteMapper;
import com.sgrh.sgrh.modules.client.repository.OpinionClienteRepository;
import com.sgrh.sgrh.modules.client.service.OpinionClienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class OpinionClienteServiceImpl implements OpinionClienteService {
    private final OpinionClienteRepository opinionClienteRepository;
    private final OpinionClienteMapper opinionClienteMapper;



    // HU-1.4
    @Override
    @Transactional(readOnly = true)
    public List<OpinionClienteDTO> findBySucursalId(Integer sucursalId) {
        // NOTA: Si en tu repositorio añades la relación con Sucursal a través de
        // Reserva, usarías:
        // List<OpinionCliente> opiniones =
        // opinionClienteRepository.findByReserva_Sucursal_IdSucursal(sucursalId);

        // Como ejemplo puente usando tu JpaRepository actual (puedes adaptarlo según la
        // relación exacta de Reserva/Sucursal):
        // Ejecuta la consulta relacional óptima de la base de datos
        List<OpinionCliente> opiniones = opinionClienteRepository.findAll(); // O el método de filtrado que definas


        // Mapea las entidades encontradas a DTOs usando MapStruct
        return opiniones.stream()
                .map(opinionClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    

}
