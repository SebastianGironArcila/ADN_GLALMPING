package com.ceiba.reserva.puerto.dao;

import com.ceiba.glamping.modelo.dto.DtoGlamping;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.tipo.modelo.dto.DtoTipo;

import java.util.List;

public interface DaoReserva {

    /**
     *
     * permite listar las reservas
     * @return las reservas
     */
    List<DtoReserva> listar();

    /**
     * Permite retornar el glamping
     * @param idGlamping
     * @return glamping
     */

    DtoGlamping retonarGlampingPorId(Long idGlamping);

    /**
     * Permite retornar el tipo de glamping
     * @param idTipoGlamping
     * @return tipoGlamping
     */

    DtoTipo retonarElTipoDeGlampingPorId(Long idTipoGlamping);



}
