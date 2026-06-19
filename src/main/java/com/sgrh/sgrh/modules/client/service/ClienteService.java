package com.sgrh.sgrh.modules.client.service;

import java.util.List;

import com.sgrh.sgrh.modules.client.dto.ClienteDTO;

public interface ClienteService {
    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO obtenerClienteById(Integer idCliente);

    ClienteDTO obtenerClienteByEmail(String email);

    ClienteDTO obtenerClienteByNumeroDocumento(String numeroDocumento);

    ClienteDTO actualizarCliente(Integer idCliente, ClienteDTO clienteDTO);

    void eliminarCliente(Integer idCliente);

    List<ClienteDTO> obtenerTodosClientes();
}
