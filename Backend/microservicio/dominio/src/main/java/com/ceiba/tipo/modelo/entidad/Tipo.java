package com.ceiba.tipo.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.dominio.ValidadorArgumento.validarSoloLetras;


@Getter
public class Tipo {


    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_GLAMPING = "Se debe ingresar el tipo de glamping";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PERSONAS_MAXIMA = "Se debe ingresar la cantidad de personas maxima";
    private static final String LA_CANTIDAD_DE_PERSONAS_DEBE_SER_UN_NUMERO_POSITIVO = "La cantidad de personas debe ser un numero entero positivo";
    private static final String EL_TIPO_GLAMPING_DEBE_SER_TEXTO = "El tipo glamping solo puede contener letras";



    private Long id;
    private String definicion;
    private Long cantPersonasMax;

    public Tipo(Long id, String definicion, Long cantPersonasMax) {
        validarObligatorio(definicion,SE_DEBE_INGRESAR_EL_TIPO_DE_GLAMPING);
        validarObligatorio(cantPersonasMax,SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PERSONAS_MAXIMA);

        validarSoloLetras(definicion,EL_TIPO_GLAMPING_DEBE_SER_TEXTO);
        validarPositivo(Double.valueOf(cantPersonasMax),LA_CANTIDAD_DE_PERSONAS_DEBE_SER_UN_NUMERO_POSITIVO);


        this.id = id;
        this.definicion = definicion;
        this.cantPersonasMax = cantPersonasMax;
    }
}
