package com.ceiba.tipo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipo.modelo.dto.DtoTipo;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoGlamping implements RowMapper<DtoTipo>, MapperResult {

    @Override
    public DtoTipo mapRow(ResultSet resultSet, int rowNum) throws SQLException{
        Long id = resultSet.getLong("id");
        String definicion = resultSet.getString("definicion");
        Long cantPersonasMax = resultSet.getLong("cantPersonasMax");

        return new DtoTipo(id,definicion, cantPersonasMax);

    }
}
