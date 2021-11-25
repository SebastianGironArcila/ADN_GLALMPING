package com.ceiba.tipo.puerto.dao;

import com.ceiba.tipo.modelo.dto.DtoTipo;

import java.util.List;

public interface DaoTipo {

    /**
     *
     * permite listar los tipos de glamping
     * @return los tipos de glamping
     */

    List<DtoTipo> listar();
}
