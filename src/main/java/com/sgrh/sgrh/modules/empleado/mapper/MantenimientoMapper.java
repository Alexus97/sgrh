// package com.sgrh.sgrh.modules.empleado.mapper;

// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// import com.sgrh.sgrh.modules.empleado.dto.MantenimientoDTO;
// import com.sgrh.sgrh.modules.empleado.entity.Mantenimiento;



// @Mapper(componentModel = "spring")
// public interface MantenimientoMapper {

//     @Mapping(source = "habitacion.idHabitacion", target = "idHabitacion")
//     @Mapping(source = "estado.idEstado", target = "idEstadoMantenimiento")
//     MantenimientoDTO toDTO(Mantenimiento entity);

//     @Mapping(source = "idHabitacion", target = "habitacion.idHabitacion")
//     @Mapping(source = "idEstadoMantenimiento", target = "estado.idEstado")
//     Mantenimiento toEntity(MantenimientoDTO dto);
// }