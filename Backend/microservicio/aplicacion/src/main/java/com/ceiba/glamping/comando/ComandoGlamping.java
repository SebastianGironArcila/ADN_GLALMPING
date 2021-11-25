package com.ceiba.glamping.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoGlamping {

    private Long id;
    private Long idTipoGlamping;
    private String descripcion;
    private Double precio;
    private int estado;

}
