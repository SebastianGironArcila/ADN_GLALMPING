package com.ceiba.tipo.controlador;

import com.ceiba.tipo.consulta.ManejadorListarTipoGlamping;
import com.ceiba.tipo.modelo.dto.DtoTipo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoGlamping")
@Api(tags = {"Controlador consulta tipo glamping"})
public class ConsultaControladorTipoGlamping {

    private final ManejadorListarTipoGlamping manejadorListarTipoGlamping;

    public ConsultaControladorTipoGlamping(ManejadorListarTipoGlamping manejadorListarTipoGlamping){
        this.manejadorListarTipoGlamping = manejadorListarTipoGlamping;

    }

    @GetMapping
    @ApiOperation("Listar tipos de glamping")
    public List<DtoTipo> listar(){
        return this.manejadorListarTipoGlamping.ejecutar();
    }
}
