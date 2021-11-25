package com.ceiba.tipo.servicio.testdatabuilder;

import com.ceiba.tipo.comando.ComandoTipoGlamping;

import java.util.UUID;

public class ComandoTipoGlampingTestDataBuilder {

    private Long id;
    private String definicion;
    private Long cantPersonasMax;

    public ComandoTipoGlampingTestDataBuilder(){
        definicion = "familiar";
        cantPersonasMax = Long.valueOf(4);


    }

    public ComandoTipoGlampingTestDataBuilder conDefinicion(String definicion){
        this.definicion = definicion;
        return this;
    }



    public ComandoTipoGlampingTestDataBuilder conCantPersonasMax(Long cantPersonasMax){
        this.cantPersonasMax = cantPersonasMax;
        return this;
    }

    public ComandoTipoGlamping build(){
        return new ComandoTipoGlamping(id,definicion, cantPersonasMax);
    }


}
