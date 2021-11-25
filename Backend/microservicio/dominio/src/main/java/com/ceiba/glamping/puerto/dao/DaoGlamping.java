package com.ceiba.glamping.puerto.dao;

import com.ceiba.glamping.modelo.dto.DtoGlamping;

import java.util.List;

public interface DaoGlamping {

    /**
     *
     * permite listar los glamping
     * @return los glampings
     */

    List<DtoGlamping> listar();
}
