package com.ceiba.glamping.controlador;

import com.ceiba.glamping.consulta.ManejadorListarGlampings;
import com.ceiba.glamping.modelo.dto.DtoGlamping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/glampings")
@Api(tags = {"Controlador consulta glampings"})
public class ConsultaControladorGlamping {

    private final ManejadorListarGlampings manejadorListarGlampings;

    public ConsultaControladorGlamping(ManejadorListarGlampings manejadorListarGlampings) {
        this.manejadorListarGlampings = manejadorListarGlampings;
    }

    @GetMapping
    @ApiOperation("Listar glampings")
    public List<DtoGlamping> listar(){
        return this.manejadorListarGlampings.ejecutar();
    }
}
