package com.sgrh.sgrh.modules.admin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sgrh.sgrh.modules.admin.dto.DetalleFacturaDTO;
import com.sgrh.sgrh.modules.admin.entity.DetalleFactura;

@Mapper(componentModel = "spring")
public interface DetalleFacturaMappper {

    // Convierte de Entidad a DTO (Saca los IDs de los objetos anidados)
    @Mapping(source = "factura.idFactura", target = "idFactura")
    @Mapping(source = "servicio.idServicio", target = "idServicio")
    @Mapping(source = "promocion.idPromocion", target = "idPromocion")
    DetalleFacturaDTO toDTO(DetalleFactura entity);

    // Convierte de DTO a Entidad (Mapea los IDs planos hacia los objetos dummies de
    // JPA)
    @Mapping(source = "idFactura", target = "factura.idFactura")
    @Mapping(source = "idServicio", target = "servicio.idServicio")
    @Mapping(source = "idPromocion", target = "promocion.idPromocion")
    DetalleFactura toEntity(DetalleFacturaDTO dto);

}
