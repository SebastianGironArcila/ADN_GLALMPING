package com.ceiba.glamping.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoGlamping {
    private Long id;
    private Long idTipoGlamping;
    private String descripcion;
    private Double precio;
    private int estado;


}
