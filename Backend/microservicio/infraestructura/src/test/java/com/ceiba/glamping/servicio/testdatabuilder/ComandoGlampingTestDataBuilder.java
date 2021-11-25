package com.ceiba.glamping.servicio.testdatabuilder;

import com.ceiba.glamping.comando.ComandoGlamping;

import java.util.UUID;

public class ComandoGlampingTestDataBuilder {

    private Long id;
    private Long idTipoGlamping;
    private String descripcion;
    private Double precio;
    private int estado;

    public ComandoGlampingTestDataBuilder(){
        idTipoGlamping = Long.valueOf(1);
        descripcion = UUID.randomUUID().toString();
        precio = Double.valueOf(100000);
        estado = 0;

    }

    public ComandoGlampingTestDataBuilder conIdTipoGlamping(Long idTipoGlamping){
        this.idTipoGlamping = idTipoGlamping;
        return this;

    }

    public ComandoGlampingTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;
    }

    public ComandoGlampingTestDataBuilder conPrecio(Double precio){
        this.precio = precio;
        return this;
    }

    public ComandoGlampingTestDataBuilder conEstado(int estado){
        this.estado = estado;
        return this;
    }

    public ComandoGlamping build(){
        return new ComandoGlamping(id,idTipoGlamping,descripcion,precio,estado);
    }




}
