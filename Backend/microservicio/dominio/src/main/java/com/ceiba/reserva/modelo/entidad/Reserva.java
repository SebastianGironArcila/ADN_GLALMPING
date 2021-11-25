package com.ceiba.reserva.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;


@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_EL_ID_GLAMPING = "Se debe ingresar un identificador de un glamping";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el nombre";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTRADA = "Se debe ingresar la fecha de entrada";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_SALIDA = "Se debe ingresar la fecha de salida";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PERSONAS = "Se debe ingresar la cantidad de personas";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el numero telefonico";
    private static final String SE_DEBE_INGRESAR_EL_COSTO_TOTAL = "Se debe ingresar el costo total";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_REGISTRO = "Se debe ingresar la fecha de registro";
    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String LA_FECHA_ES_INVALIDA = "Formato de fecha no valido, debe tener la estructura YYYY-MM-DD";


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

    public Reserva(Long id, String cedula, String nombre, LocalDate fechaEntrada, Long idGlamping, int cantPersonas, String telefono, LocalDate fechaSalida, Double costoTotal, LocalDateTime fechaRegistro) {

        validarObligatorio(cedula,SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(fechaEntrada,SE_DEBE_INGRESAR_LA_FECHA_DE_ENTRADA);
        validarObligatorio(idGlamping,SE_DEBE_INGRESAR_EL_ID_GLAMPING);
        validarPositivo((double) cantPersonas,SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PERSONAS);
        validarObligatorio(telefono,SE_DEBE_INGRESAR_EL_TELEFONO);
        validarObligatorio(fechaSalida,SE_DEBE_INGRESAR_LA_FECHA_DE_SALIDA);
        validarPositivo(costoTotal,SE_DEBE_INGRESAR_EL_COSTO_TOTAL);
        validarObligatorio(fechaRegistro,SE_DEBE_INGRESAR_LA_FECHA_DE_REGISTRO);

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaEntrada = fechaEntrada;
        this.idGlamping = idGlamping;
        this.cantPersonas = cantPersonas;
        this.telefono = telefono;
        this.fechaSalida = fechaSalida;
        this.costoTotal = costoTotal;
        this.fechaRegistro = fechaRegistro;
    }



}
