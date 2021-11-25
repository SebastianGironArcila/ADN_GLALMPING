package com.ceiba.glamping.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Glamping {

    private static final String SE_DEBE_INGRESAR_UN_ID_DE_TIPO_DE_GLAMPING = "Se debe ingresar un identificador de un tipo de glamping";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio";
    private static final String SE_DEBE_INGRESAR_EL_ESTADO = "Se debe ingresar el estado";


    private Long id;
    private Long idTipoGlamping;
    private String descripcion;
    private Double precio;
    private int estado;

    public Glamping(Long id, Long idTipoGlamping, String descripcion, Double precio, int estado) {

        validarObligatorio(idTipoGlamping, SE_DEBE_INGRESAR_UN_ID_DE_TIPO_DE_GLAMPING);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(precio,SE_DEBE_INGRESAR_EL_PRECIO);
        validarPositivoConCero((double)estado,SE_DEBE_INGRESAR_EL_ESTADO);




        this.id = id;
        this.idTipoGlamping = idTipoGlamping;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
}
