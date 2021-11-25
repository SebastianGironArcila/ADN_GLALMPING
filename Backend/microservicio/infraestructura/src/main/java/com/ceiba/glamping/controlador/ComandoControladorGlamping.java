package com.ceiba.glamping.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.glamping.comando.ComandoGlamping;
import com.ceiba.glamping.comando.manejador.ManejadorCrearGlamping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/glamping")
@Api(tags = {"Controlador comando glamping"})
public class ComandoControladorGlamping {

    private final ManejadorCrearGlamping manejadorCrearGlamping;

    @Autowired
    public ComandoControladorGlamping(ManejadorCrearGlamping manejadorCrearGlamping){
        this.manejadorCrearGlamping = manejadorCrearGlamping;

    }

    @PostMapping
    @ApiOperation("Crear glamping")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoGlamping comandoGlamping){
        return manejadorCrearGlamping.ejecutar(comandoGlamping);

    }


}

