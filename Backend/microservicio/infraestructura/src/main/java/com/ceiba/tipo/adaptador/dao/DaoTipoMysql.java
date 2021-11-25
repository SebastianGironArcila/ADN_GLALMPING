package com.ceiba.tipo.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipo.modelo.dto.DtoTipo;
import com.ceiba.tipo.puerto.dao.DaoTipo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTipoMysql implements DaoTipo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="tipoGlamping", value="listar")
    private static String sqlListar;

    public DaoTipoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTipo> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTipoGlamping());
    }
}
