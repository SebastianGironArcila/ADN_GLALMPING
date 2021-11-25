package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaTestDataBuilder {
    private Long id;
    private Long idGlamping;
    private String cedula;
    private String nombre;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int cantPersonas;
    private String telefono;
    private double costoTotal;
    private LocalDateTime fechaRegistro;

    public ReservaTestDataBuilder() {

        idGlamping = Long.valueOf(1);
        cedula = "1116275325";
        nombre = "Duvan";
        fechaEntrada = LocalDate.now();
        fechaSalida =  LocalDate.now().plusDays(3);
        cantPersonas = 2;
        telefono = "3198755856";
        costoTotal = Double.valueOf(9894444);
        fechaRegistro = LocalDateTime.now();

    }

    public ReservaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conIdGlamping(Long idGlamping) {
        this.idGlamping = idGlamping;
        return this;

    }

    public ReservaTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;

    }

    public ReservaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;

    }

    public ReservaTestDataBuilder conFechaEntrada(LocalDate fechaEntrada){
        this.fechaEntrada= fechaEntrada;
        return this;

    }

    public ReservaTestDataBuilder conFechaSalida(LocalDate fechaSalida){
        this.fechaSalida= fechaSalida;
        return this;

    }

    public ReservaTestDataBuilder conCantPersonas(int cantPersonas){
        this.cantPersonas= cantPersonas;
        return this;

    }

    public ReservaTestDataBuilder conTelefono(String telefono){
        this.telefono= telefono;
        return this;

    }

    public ReservaTestDataBuilder conCostoTotal(double costoTotal){
        this.costoTotal= costoTotal;
        return this;

    }

    public ReservaTestDataBuilder conFechaRegistro(LocalDateTime fechaRegistro){
        this.fechaRegistro= fechaRegistro;
        return this;

    }

    public Reserva build(){
        return new Reserva(id,cedula,nombre,fechaEntrada,idGlamping,cantPersonas,telefono,fechaSalida,costoTotal,fechaRegistro);
    }
}
