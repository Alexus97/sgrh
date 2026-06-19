package com.sgrh.sgrh.modules.admin.service;

import java.time.LocalDate;
import java.util.List;
import com.sgrh.sgrh.modules.admin.dto.PromocionDTO;

public interface PromocionService {
    PromocionDTO crearPromocion(PromocionDTO dto);
    PromocionDTO obtenerPorId(Integer idPromocion);
    List<PromocionDTO> obtenerTodas();
    PromocionDTO actualizarPromocion(Integer idPromocion, PromocionDTO dto);
    void eliminarPromocion(Integer idPromocion);
    List<PromocionDTO> obtenerVigentes(LocalDate fecha);
}