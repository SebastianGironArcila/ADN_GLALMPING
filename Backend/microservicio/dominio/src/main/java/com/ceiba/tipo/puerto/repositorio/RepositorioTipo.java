package com.ceiba.tipo.puerto.repositorio;

import com.ceiba.tipo.modelo.entidad.Tipo;


public interface RepositorioTipo {

    /**
     * Permite crear un tipo de glamping
     * @param tipo
     * @return el id generado
     */
    Long crear(Tipo tipo);



}
