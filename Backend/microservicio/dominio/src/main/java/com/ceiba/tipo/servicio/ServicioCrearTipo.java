package com.ceiba.tipo.servicio;

import com.ceiba.tipo.modelo.entidad.Tipo;
import com.ceiba.tipo.puerto.repositorio.RepositorioTipo;

public class ServicioCrearTipo {

    private final RepositorioTipo repositorioTipo;

    public ServicioCrearTipo(RepositorioTipo repositorioTipo){
        this.repositorioTipo = repositorioTipo;
    }

    public Long ejecutar(Tipo tipo){
        return this.repositorioTipo.crear(tipo);

    }



}
