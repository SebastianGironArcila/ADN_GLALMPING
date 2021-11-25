package com.ceiba.tipo.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipo.modelo.entidad.Tipo;
import com.ceiba.tipo.puerto.repositorio.RepositorioTipo;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTipoMysql implements RepositorioTipo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoGlamping", value="crear")
    private static String sqlCrear;



    public RepositorioTipoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Tipo tipo){
        return this.customNamedParameterJdbcTemplate.crear(tipo,sqlCrear);
    }

}
