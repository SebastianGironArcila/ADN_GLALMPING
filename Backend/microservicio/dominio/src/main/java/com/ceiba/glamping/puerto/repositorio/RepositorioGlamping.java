package com.ceiba.glamping.puerto.repositorio;

import com.ceiba.glamping.modelo.entidad.Glamping;

public interface RepositorioGlamping {

    /**
     * Permite crear un glamping
     * @param glamping
     * @return el id generado
     */

    Long crear(Glamping glamping);

    /**
     * Permite validar si existe un tipo de glamping con ese id
     * @param idTipoGlamping
     * @return si existe o no
     */

    boolean existeTipoGlamping(Long idTipoGlamping);

    /**
     * Permite retornar el glamping
     * @param idGlamping
     * @return glamping
     */

    Glamping buscarPorId(Long idGlamping);

}
