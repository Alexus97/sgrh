// package com.sgrh.sgrh.modules.empleado.mapper;

// import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;

// import com.sgrh.sgrh.modules.empleado.dto.AsignacionRolDTO;
// import com.sgrh.sgrh.modules.empleado.entity.AsignacionRol;

// @Mapper(componentModel = "spring")
// public interface AsignacionRolMapper {
//     @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
//     @Mapping(source = "rol.idRol", target = "idRol")
//     AsignacionRolDTO toDTO( AsignacionRol entity);

//     @Mapping(source = "idEmpleado", target = "empleado.idEmpleado")
//     @Mapping(source = "idRol", target = "rol.idRol")
//     AsignacionRol toEntity( AsignacionRolDTO dto);
// }
