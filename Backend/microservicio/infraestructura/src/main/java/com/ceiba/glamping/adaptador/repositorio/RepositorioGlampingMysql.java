package com.ceiba.glamping.adaptador.repositorio;

import com.ceiba.glamping.modelo.entidad.Glamping;
import com.ceiba.glamping.puerto.repositorio.RepositorioGlamping;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioGlampingMysql implements RepositorioGlamping {

    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "glamping",value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "tipoGlamping",value="existeTipoGlamping")
    private static String sqlExisteTipoGlamping;

    @SqlStatement(namespace = "glamping",value = "existePorId")
    private static String sqlExistePorId;


    public RepositorioGlampingMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Glamping glamping) {

        return this.customNamedParameterJdbcTemplate.crear(glamping,sqlCrear);
    }

    @Override
    public boolean existeTipoGlamping(Long idTipoGlamping) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idTipoGlamping",idTipoGlamping);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTipoGlamping,paramSource,Boolean.class);

    }

    @Override
    public Glamping buscarPorId(Long idGlamping) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idGlamping",idGlamping);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource,Glamping.class);

    }
}
