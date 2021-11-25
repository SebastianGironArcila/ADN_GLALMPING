package com.ceiba.tipo.consulta;


import com.ceiba.tipo.modelo.dto.DtoTipo;
import com.ceiba.tipo.puerto.dao.DaoTipo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTipoGlamping {

    private final DaoTipo daoTipo;

    public ManejadorListarTipoGlamping(DaoTipo daoTipo){this.daoTipo = daoTipo;}

    public List<DtoTipo> ejecutar(){ return this.daoTipo.listar(); }
}
