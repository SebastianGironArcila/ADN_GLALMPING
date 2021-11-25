package com.ceiba.glamping.adaptador.dao;


import com.ceiba.glamping.modelo.dto.DtoGlamping;
import com.ceiba.glamping.puerto.dao.DaoGlamping;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoGlampingMysql implements DaoGlamping {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="glamping", value="listar")
    private static String sqlListar;

    public DaoGlampingMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoGlamping> listar(){
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoGlamping());

    }


}
