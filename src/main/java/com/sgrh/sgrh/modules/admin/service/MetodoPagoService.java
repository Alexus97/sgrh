package com.sgrh.sgrh.modules.admin.service;

import java.util.List;
import com.sgrh.sgrh.modules.admin.dto.MetodoPagoDTO;

public interface MetodoPagoService {
    MetodoPagoDTO crearMetodoPago(MetodoPagoDTO dto);
    MetodoPagoDTO obtenerPorId(Integer id);
    List<MetodoPagoDTO> obtenerTodos();
    MetodoPagoDTO actualizarMetodoPago(Integer id, MetodoPagoDTO dto);
    void eliminarMetodoPago(Integer id);
}