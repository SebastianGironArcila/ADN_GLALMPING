package com.ceiba.glamping.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.glamping.modelo.entidad.Glamping;
import com.ceiba.glamping.puerto.repositorio.RepositorioGlamping;


public class ServicioCrearGlamping {

    private static final String EL_TIPO_GLAMPING_NO_EXISTE_EN_EL_SISTEMA = "El tipo de glamping no esta registrado en el sistema";

    private final RepositorioGlamping repositorioGlamping;

    public ServicioCrearGlamping(RepositorioGlamping repositorioGlamping){
        this.repositorioGlamping = repositorioGlamping;

    }

    public Long ejecutar(Glamping glamping){
        validarExistenciaTipoGlamping(glamping);
        return this.repositorioGlamping.crear(glamping);

    }

    private void validarExistenciaTipoGlamping(Glamping glamping){
        boolean existe = this.repositorioGlamping.existeTipoGlamping(glamping.getIdTipoGlamping());
        if(!existe){
            throw new ExcepcionValorInvalido(EL_TIPO_GLAMPING_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
