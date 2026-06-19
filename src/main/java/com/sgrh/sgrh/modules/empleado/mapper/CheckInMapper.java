


// package com.sgrh.sgrh.modules.empleado.mapper;

// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// import com.sgrh.sgrh.modules.empleado.dto.CheckInDTO;
// import com.sgrh.sgrh.modules.empleado.entity.CheckIn;






// @Mapper(componentModel = "spring")
// public interface CheckInMapper {

//     // De Entidad a DTO: Extrae los IDs primitivos navegando por los objetos de relación
//     @Mapping(source = "reserva.idReserva", target = "idReserva")
//     @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
//     CheckInDTO toDTO( CheckIn entity);

//     // De DTO a Entidad: Reconstruye las relaciones anidadas asignando los IDs provenientes del DTO
//     @Mapping(source = "idReserva", target = "reserva.idReserva")
//     @Mapping(source = "idEmpleado", target = "empleado.idEmpleado")
//     CheckIn toEntity(CheckInDTO dto);
// }