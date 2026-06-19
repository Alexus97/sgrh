// package com.sgrh.sgrh.modules.empleado.mapper;

// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// import com.sgrh.sgrh.modules.empleado.dto.LimpiezaDTO;
// import com.sgrh.sgrh.modules.empleado.entity.Limpieza;

// @Mapper(componentModel = "spring")
// public interface LimpiezaMapper {

//     @Mapping(source = "habitacion.idHabitacion", target = "idHabitacion")
//     @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
//     LimpiezaDTO toDTO( Limpieza entity);

//     @Mapping(target = "habitacion", ignore = true)
//     @Mapping(target = "empleado", ignore = true)
//     Limpieza toEntity(LimpiezaDTO dto);
// }