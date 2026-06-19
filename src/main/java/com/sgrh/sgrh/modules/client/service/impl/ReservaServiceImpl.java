// package com.sgrh.sgrh.modules.client.service.impl;

// import java.time.LocalDate;
// import java.util.List;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.sgrh.sgrh.core.exception.ResourceNotFoundException;
// import com.sgrh.sgrh.modules.client.dto.ReservaDTO;
// import com.sgrh.sgrh.modules.client.entity.Reserva;
// import com.sgrh.sgrh.modules.client.entity.ReservaHabitacion;
// import com.sgrh.sgrh.modules.client.mapper.ReservaMapper;
// import com.sgrh.sgrh.modules.client.repository.ReservaHabitacionRepository;
// import com.sgrh.sgrh.modules.client.repository.ReservaRepository;
// import com.sgrh.sgrh.modules.client.service.ReservaService;
// import com.sgrh.sgrh.modules.admin.entity.Habitacion;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// @Transactional
// public class ReservaServiceImpl implements ReservaService {
//     private final ReservaRepository reservaRepository;
//     private final ReservaHabitacionRepository reservaHabitacionRepository;
//     private final ReservaMapper reservaMapper;

//     @Override
//     public ReservaDTO crearReserva(ReservaDTO reservaDTO) {
//         var reserva = reservaMapper.toEntity(reservaDTO);
//         var reservaGuardada = reservaRepository.save(reserva);
//         return reservaMapper.toDTO(reservaGuardada);
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public ReservaDTO obtenerReservaById(Integer idReserva) {
//         var reserva = reservaRepository.findById(idReserva)
//                 .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));
//         return reservaMapper.toDTO(reserva);
//     }



//     @Override
//     public void eliminarReserva(Integer idReserva) {
//         if (!reservaRepository.existsById(idReserva)) {
//             throw new ResourceNotFoundException("Reserva no encontrada");
//         }
//         reservaRepository.deleteById(idReserva);
//     }

//     // @Override
//     // @Transactional(readOnly = true)
//     // public List<ReservaDTO> obtenerReservasByCliente(Integer idCliente) {
//     //     return reservaRepository.findByClienteIdCliente(idCliente)
//     //             .stream()
//     //             .map(reservaMapper::toDTO)
//     //             .toList();
//     // }

//     @Override
//     @Transactional(readOnly = true)
//     public List<ReservaDTO> obtenerReservasByEstado(Integer idEstado) {
//         return reservaRepository.findByEstadoReservaIdEstado(idEstado)
//                 .stream()
//                 .map(reservaMapper::toDTO)
//                 .toList();
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<ReservaDTO> obtenerTodas() {
//         return reservaRepository.findAll()
//                 .stream()
//                 .map(reservaMapper::toDTO)
//                 .toList();
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public List<ReservaDTO> obtenerReservasByFechas(LocalDate fechaEntrada, LocalDate fechaSalida) {
//         return reservaRepository.findByFechaEntradaAndFechaSalida(fechaEntrada, fechaSalida)
//                 .stream()
//                 .map(reservaMapper::toDTO)
//                 .toList();
//     }

   
// }
