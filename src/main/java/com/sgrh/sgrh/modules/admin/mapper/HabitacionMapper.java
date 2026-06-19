package com.sgrh.sgrh.modules.admin.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.sgrh.sgrh.modules.admin.dto.HabitacionDTO;
import com.sgrh.sgrh.modules.admin.dto.HabitacionDetalleDTO;
import com.sgrh.sgrh.modules.admin.entity.Habitacion;
import com.sgrh.sgrh.modules.admin.entity.ImagenHabitacion;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {


    // --- Tus mapeos CRUD básicos (Déjalos como estaban) ---
    // @Mapping(source = "tipoHabitacion.idTipo", target = "idTipo")
    // @Mapping(source = "sucursalHotel.idSucursal", target = "idSucursal")
    // @Mapping(source = "estadoHabitacion.idEstado", target = "idEstado")
    // HabitacionDTO toDTO(Habitacion entity);

    // @Mapping(source = "idTipo", target = "tipoHabitacion.idTipo")
    // @Mapping(source = "idSucursal", target = "sucursalHotel.idSucursal")
    // @Mapping(source = "idEstado", target = "estadoHabitacion.idEstado")
    // Habitacion toEntity(HabitacionDTO dto);

    // --- Tus mapeos CRUD básicos ---
    @Mapping(source = "tipoHabitacion.idTipo", target = "idTipo")
    @Mapping(source = "sucursalHotel.idSucursal", target = "idSucursal")
    @Mapping(source = "estado.idEstado", target = "idEstadoHabitacion") // <- Ajustado al nombre del DTO
    HabitacionDTO toDTO(Habitacion entity);

    @Mapping(source = "idTipo", target = "tipoHabitacion.idTipo")
    @Mapping(source = "idSucursal", target = "sucursalHotel.idSucursal")
    @Mapping(source = "idEstadoHabitacion", target = "estado.idEstado") // <- Ajustado al nombre del DTO
    Habitacion toEntity(HabitacionDTO dto);


    // --- EL CORREGIDO PARA LA HU-3 ---
    // @Mapping(source = "habitacion.idHabitacion", target = "idHabitacion")
    // @Mapping(source = "habitacion.numero", target = "numero")
    // @Mapping(source = "habitacion.capacidad", target = "capacidad")
    // @Mapping(source = "habitacion.precioNoche", target = "precioNoche")
    
    // // Usamos .descripcion de TipoHabitacion que ya confirmamos que sí existe
    // @Mapping(source = "habitacion.tipoHabitacion.descripcion", target = "nombreTipo")
    // @Mapping(source = "habitacion.tipoHabitacion.descripcion", target = "descripcionTipo")
    
    // // OJO AQUÍ: Como no sabemos si Sucursal o Estado tienen un String 'nombre', 
    // // mapeamos temporalmente sus IDs convertidos a String para que MapStruct no falle.
    // @Mapping(source = "habitacion.sucursalHotel.idSucursal", target = "nombreSucursal") 
    // @Mapping(source = "habitacion.estadoHabitacion.idEstado", target = "nombreEstado")
    
    // // Mapeo de la lista de imágenes
    // @Mapping(source = "imagenes", target = "imagenesUrls", qualifiedByName = "mapearUrlsLista")
    // HabitacionDetalleDTO toDetalleDTO(Habitacion habitacion, List<ImagenHabitacion> imagenes);

    // --- EL CORREGIDO PARA LA HU-3 ---
    @Mapping(source = "habitacion.idHabitacion", target = "idHabitacion")
    @Mapping(source = "habitacion.numero", target = "numero")
    @Mapping(source = "habitacion.capacidad", target = "capacidad")
    @Mapping(source = "habitacion.precioNoche", target = "precioNoche")

    // Usamos la descripción del tipo que viene dentro del objeto anidado
    @Mapping(source = "habitacion.tipoHabitacion.descripcion", target = "tipoDescripcion") 

    // IDs directos de las relaciones de la habitación
    @Mapping(source = "habitacion.sucursalHotel.idSucursal", target = "idSucursal")
    @Mapping(source = "habitacion.estado.idEstado", target = "idEstado")

    // Mapeo de la lista de imágenes usando tu método default de abajo
    @Mapping(source = "imagenes", target = "imagenesUrls", qualifiedByName = "mapearUrlsLista")
    HabitacionDetalleDTO toDetalleDTO(Habitacion habitacion, List<ImagenHabitacion> imagenes);

    @Named("mapearUrlsLista")
    default List<String> mapearUrlsLista(List<ImagenHabitacion> imagenes) {
        if (imagenes == null) return null;
        return imagenes.stream()
                .map(ImagenHabitacion::getUrlImagen)
                .collect(Collectors.toList());
    }
}