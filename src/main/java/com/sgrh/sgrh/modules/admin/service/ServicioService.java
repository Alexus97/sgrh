package com.sgrh.sgrh.modules.admin.service;

import java.util.List;

import com.sgrh.sgrh.modules.admin.dto.ServicioDTO;

public interface ServicioService {
    ServicioDTO crearServicio(ServicioDTO servicioDTO);

    ServicioDTO obtenerServicioById(Integer idServicio);

    List<ServicioDTO> obtenerTodos();

    ServicioDTO actualizarServicio(Integer idServicio, ServicioDTO servicioDTO);

    void eliminarServicio(Integer idServicio);


    //HU-1.3 
    List<ServicioDTO> listarServiciosPorSucursal(Integer idSucursal);
}