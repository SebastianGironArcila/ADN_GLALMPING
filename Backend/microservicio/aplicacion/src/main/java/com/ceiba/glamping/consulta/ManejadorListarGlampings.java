package com.ceiba.glamping.consulta;


import com.ceiba.glamping.modelo.dto.DtoGlamping;
import com.ceiba.glamping.puerto.dao.DaoGlamping;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ManejadorListarGlampings {

    private final DaoGlamping daoGlamping;

    public ManejadorListarGlampings(DaoGlamping daoGlamping){
        this.daoGlamping = daoGlamping;
    }

    public List<DtoGlamping> ejecutar(){
        return this.daoGlamping.listar();
    }
}
