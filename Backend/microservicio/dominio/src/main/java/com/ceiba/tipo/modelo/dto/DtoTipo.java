package com.ceiba.tipo.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipo {

    private Long id;
    private String definicion;
    private Long cantPersonasMax;
}
