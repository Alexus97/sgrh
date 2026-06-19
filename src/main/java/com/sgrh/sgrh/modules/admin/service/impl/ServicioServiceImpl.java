package com.sgrh.sgrh.modules.admin.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgrh.sgrh.core.exception.ResourceNotFoundException;
import com.sgrh.sgrh.modules.admin.dto.ServicioDTO;
import com.sgrh.sgrh.modules.admin.mapper.ServicioMapper;
import com.sgrh.sgrh.modules.admin.repository.ServicioRepository;
import com.sgrh.sgrh.modules.admin.repository.SucursalHotelRepository;
import com.sgrh.sgrh.modules.admin.service.ServicioService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    private final ServicioMapper servicioMapper;
    private final SucursalHotelRepository sucursalHotelRepository;

    @Override
    public ServicioDTO crearServicio(ServicioDTO servicioDTO) {
        var servicio = servicioMapper.toEntity(servicioDTO);
        var servicioGuardado = servicioRepository.save(servicio);
        return servicioMapper.toDTO(servicioGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public ServicioDTO obtenerServicioById(Integer idServicio) {
        var servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio no encontrado con ID: " + idServicio));
        return servicioMapper.toDTO(servicio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServicioDTO> obtenerTodos() {
        return servicioRepository.findAll()
                .stream()
                .map(servicioMapper::toDTO)
                .toList();
    }

    @Override
    public ServicioDTO actualizarServicio(Integer idServicio, ServicioDTO servicioDTO) {
        if (!servicioRepository.existsById(idServicio)) {
            throw new ResourceNotFoundException("Servicio no encontrado con ID: " + idServicio);
        }
        var servicioActualizado = servicioMapper.toEntity(servicioDTO);
        servicioActualizado.setIdServicio(idServicio); // Aseguramos que conserve el ID de la URL
        var servicioGuardado = servicioRepository.save(servicioActualizado);
        return servicioMapper.toDTO(servicioGuardado);
    }

    @Override
    public void eliminarServicio(Integer idServicio) {
        if (!servicioRepository.existsById(idServicio)) {
            throw new ResourceNotFoundException("Servicio no encontrado con ID: " + idServicio);
        }
        servicioRepository.deleteById(idServicio);
    }


    // HU-1.3 
    @Override
    @Transactional(readOnly = true)
    public List<ServicioDTO> listarServiciosPorSucursal(Integer idSucursal) {
        // Validamos la existencia de la sucursal de manera funcional
        if (!sucursalHotelRepository.existsById(idSucursal)) {
            throw new EntityNotFoundException("La sucursal con ID " + idSucursal + " no existe.");
        }

        // Inferencia de tipos locales con 'var'
        var serviciosEntities = servicioRepository.findServiciosBySucursalId(idSucursal);
        
        // Transformación limpia usando MapStruct a través de Stream
        var dtoList = serviciosEntities.stream()
                .map(servicioMapper::toDTO)
                .toList();
                
        // Retorno de factoría de colecciones inmutables
        return List.copyOf(dtoList);
    }
}