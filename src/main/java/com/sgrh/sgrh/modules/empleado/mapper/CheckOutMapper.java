// package com.sgrh.sgrh.modules.empleado.mapper;

// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// import com.sgrh.sgrh.modules.empleado.dto.CheckOutDTO;
// import com.sgrh.sgrh.modules.empleado.entity.CheckOut;

// @Mapper(componentModel = "spring")
// public interface CheckOutMapper {
//     @Mapping(source = "reserva.idReserva", target = "idReserva")
//     @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
//     CheckOutDTO toDTO(CheckOut entity);

//     @Mapping(source = "idReserva", target = "reserva.idReserva")
//     @Mapping(source = "idEmpleado", target = "empleado.idEmpleado")
//     CheckOut toEntity(CheckOutDTO dto);
// }
