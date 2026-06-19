package com.sgrh.sgrh.modules.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgrh.sgrh.modules.admin.dto.HabitacionDetalleDTO;
import com.sgrh.sgrh.modules.admin.dto.ServicioDTO;
import com.sgrh.sgrh.modules.admin.dto.SucursalHotelDTO;
import com.sgrh.sgrh.modules.admin.service.HabitacionService;
import com.sgrh.sgrh.modules.admin.service.ServicioService;
import com.sgrh.sgrh.modules.admin.service.SucursalHotelService;
import com.sgrh.sgrh.modules.client.dto.OpinionClienteDTO;
import com.sgrh.sgrh.modules.client.service.OpinionClienteService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/sucursal")
@RequiredArgsConstructor
public class Sucursal {



    private final OpinionClienteService opinionClienteService;
    private final HabitacionService habitacionService;
    private final SucursalHotelService service;
    private final ServicioService servicioService;

    /**
     * HU-1: Endpoint para Obtener la información general del hotel.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SucursalHotelDTO> obtenerSucursalPorId(@PathVariable("id") Integer idsucursal) {
        var response = service.obtenerPorId(idsucursal);
        return ResponseEntity.ok(response);
    }

    /**
     * HU-1.2: Endpoint para Listar las habitaciones disponibles en esa sucursal.
     */
    @GetMapping("/{id}/habitaciones")
    public ResponseEntity<List<HabitacionDetalleDTO>> listarHabitacionesPorSucursal(
        @PathVariable("id") @NotNull @Positive Integer id) {
        
        // var habitacionesDisponibles = habitacionService.obtenerHabitacionesDisponiblesPorSucursal(id);
        List<HabitacionDetalleDTO> habitacionesDisponibles = habitacionService.obtenerHabitacionesDisponiblesPorSucursal(id);
        
        return ResponseEntity.ok(habitacionesDisponibles);
    }


    /**
     * HU-1.3: Endpoint para listar los servicios que ofrece el hotel (Wifi, piscina, restaurante, etc.).
     */
    @GetMapping("/{id}/servicios")
    public ResponseEntity<List<ServicioDTO>> getServiciosPorSucursal(@PathVariable("id") Integer id) {
        // 'var' local para cumplir con el estándar de código limpio de Java 21
        var servicios = servicioService.listarServiciosPorSucursal(id);
        
        return ResponseEntity.ok(servicios);
    }


    /**
     * HU-1.4: Endpoint para Obtener las reseñas y calificaciones dejadas por otros usuarios.
     */
    @GetMapping("/{id}/resenas")
    public ResponseEntity<List<OpinionClienteDTO>> obtenerResenas(@PathVariable("id") Integer id) {
        List<OpinionClienteDTO> resenas = opinionClienteService.findBySucursalId(id);
        if (resenas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resenas);
    }

    /**
     * HU-3: Endpoint para consumir la vista detallada de una habitación concreta.
     */
    @GetMapping("/{id}/detalle")
    public ResponseEntity<HabitacionDetalleDTO> obtenerDetalleHabitacion(@PathVariable("id") Integer id) {
        // CORREGIDO: Ahora llama correctamente al servicio de habitaciones
        HabitacionDetalleDTO detalle = habitacionService.obtenerDetallePorId(id);
        return new ResponseEntity<>(detalle, HttpStatus.OK);
    }



    

}





















































































// /**
//      * HU-1: Endpoint para Obtener Obtener la información general del hotel (incluyendo su ubicación).
//      * Rol: Cliente
//      */
//     @GetMapping("/{id}")
//     public ResponseEntity<SucursalHotelDTO> obtenerSucursalPorId(@PathVariable Integer idsucursal) {
//         // Uso estricto de 'var'
//         var response = service.obtenerPorId(idsucursal);
//         return ResponseEntity.ok(response);
//     }


//     /**
//      * HU-1.2: Endpoint para Listar las habitaciones y tipos de habitaciones disponibles en esa sucursal.
//      * Rol: Cliente
//      */
//     @GetMapping("/{id}/habitaciones")
//     public ResponseEntity<List<HabitacionDetalleDTO>> listarHabitacionesPorSucursal(
//             @PathVariable("id") @NotNull @Positive Integer id) {
        
//         var habitacionesDisponibles = habitacionService.listarHabitacionesDisponiblesPorSucursal(id);
        
//         return ResponseEntity.ok(habitacionesDisponibles);
//     }



//     /**
//      * HU-1.4: Endpoint para Obtener las reseñas y calificaciones dejadas por otros usuarios.
//      * Rol: Cliente
//      */

//     // @GetMapping("/{idSucursal}/habitaciones")
//     // public ResponseEntity<List<HabitacionDTO>> obtenerHabitacionesDisponiblesPorSucursal(
//     //         @PathVariable("idSucursal") Integer idSucursal) {
        
//     //     List<HabitacionDTO> habitaciones = habitacionService.obtenerHabitacionesDisponiblesPorSucursal(idSucursal);
//     //     return ResponseEntity.ok(habitaciones);
//     // }


//     /**
//      * HU-1.4: Endpoint para Obtener las reseñas y calificaciones dejadas por otros usuarios.
//      * Rol: Cliente
//      */
//     @GetMapping("/{id}/resenas")
//     public ResponseEntity<List<OpinionClienteDTO>> obtenerResenas(@PathVariable Integer id) {
//         List<OpinionClienteDTO> resenas = opinionClienteService.findBySucursalId(id);
        
//         if (resenas.isEmpty()) {
//             return ResponseEntity.noContent().build(); // Retorna 204 No Content si está vacía
//         }
        
//         return ResponseEntity.ok(resenas); // Retorna 200 OK con la lista de reseñas mapeadas
//     }



//     /**
//      * HU-3: Endpoint para consumir la vista detallada de una habitación concreta.
//      * Rol: Cliente
//      */
//     @GetMapping("/{id}/detalle")
//     public ResponseEntity<HabitacionDetalleDTO> obtenerDetalleHabitacion(@PathVariable Integer id) {
//         HabitacionDetalleDTO detalle = imagenHabitacionService.obtenerDetallePorId(id);
//         return new ResponseEntity<>(detalle, HttpStatus.OK);
//     }