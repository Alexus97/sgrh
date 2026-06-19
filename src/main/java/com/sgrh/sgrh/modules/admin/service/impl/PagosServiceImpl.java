package com.sgrh.sgrh.modules.admin.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgrh.sgrh.core.exception.ResourceNotFoundException;
import com.sgrh.sgrh.modules.admin.dto.PagoDTO;
import com.sgrh.sgrh.modules.admin.mapper.PagoMapper;
import com.sgrh.sgrh.modules.admin.repository.PagoRepository;
import com.sgrh.sgrh.modules.admin.service.PagoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PagosServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    @Override
    public PagoDTO registrarPago(PagoDTO pagoDTO) {
        var pago = pagoMapper.toEntity(pagoDTO);
        var pagoGuardado = pagoRepository.save(pago);
        return pagoMapper.toDTO(pagoGuardado);
    }

    @Override
    public PagoDTO obtenerPagoById(Integer id) {
        var pago = pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        return pagoMapper.toDTO(pago);
    }

    @Override
    public PagoDTO actualizarPago(Integer id, PagoDTO pagoDTO) {
        // Verificar que el pago exista
        pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado"));
        
        // Mapear DTO a entidad y guardar
        var pagoActualizado = pagoMapper.toEntity(pagoDTO);
        var pagoGuardado = pagoRepository.save(pagoActualizado);
        return pagoMapper.toDTO(pagoGuardado);
    }

    @Override
    public void eliminarPago(Integer id) {
        if (!pagoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pago no encontrado");
        }
        pagoRepository.deleteById(id);
    }

    @Override
    public List<PagoDTO> obtenerTodos() {
        return pagoRepository.findAll().stream()
                .map(pagoMapper::toDTO)
                .toList();
    }

    @Override
    public List<PagoDTO> obtenerPagosPorReserva(Integer idReserva) {
        // Implementación si es necesario buscar pagos por reserva
        return Collections.emptyList();
    }
}
