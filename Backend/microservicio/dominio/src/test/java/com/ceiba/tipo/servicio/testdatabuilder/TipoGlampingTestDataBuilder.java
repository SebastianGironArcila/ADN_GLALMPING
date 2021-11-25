package com.ceiba.tipo.servicio.testdatabuilder;

import com.ceiba.tipo.modelo.dto.DtoTipo;
import com.ceiba.tipo.modelo.entidad.Tipo;

public class TipoGlampingTestDataBuilder {

    private Long id;
    private String definicion;
    private Long cantPersonasMax;

    public TipoGlampingTestDataBuilder(){
        definicion = "familiar";
        cantPersonasMax = 4L;


    }



    public TipoGlampingTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public TipoGlampingTestDataBuilder conTipo(String definicion){
        this.definicion = definicion;
        return this;
    }



    public TipoGlampingTestDataBuilder conCantPersonasMax(Long cantPersonasMax){
        this.cantPersonasMax = cantPersonasMax;
        return this;
    }

    public Tipo build(){
        return new Tipo(id,definicion, cantPersonasMax);
    }

    public DtoTipo buildDt(){ return new DtoTipo(id,definicion, cantPersonasMax); }
}
