package com.sgrh.sgrh.modules.admin.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer idHabitacion;

    @Column(name = "id_tipo", nullable = false)
    private Integer idTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sucursal", nullable = false)
    private SucursalHotel sucursalHotel;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "precio_noche", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioNoche;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_habitacion", nullable = false)
    private Estado estado;

}
