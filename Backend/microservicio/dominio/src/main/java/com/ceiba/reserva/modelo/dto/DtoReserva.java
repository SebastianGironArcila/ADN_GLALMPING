package com.ceiba.reserva.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private String cedula;
    private String nombre;
    private LocalDate fechaEntrada;
    private Long idGlamping;
    private int cantPersonas;
    private String telefono;
    private LocalDate fechaSalida;
    private Double costoTotal;
    private LocalDateTime fechaRegistro;

}

