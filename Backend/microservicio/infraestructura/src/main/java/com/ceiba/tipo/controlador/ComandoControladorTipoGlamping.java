package com.ceiba.tipo.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.tipo.comando.manejador.ManejadorCrearTipoGlamping;
import com.ceiba.tipo.comando.ComandoTipoGlamping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoGlamping")
@Api(tags = {"Controlador comando tipo glamping"})
public class ComandoControladorTipoGlamping {

    private final ManejadorCrearTipoGlamping manejadorCrearTipoGlamping;

    @Autowired
    public ComandoControladorTipoGlamping(ManejadorCrearTipoGlamping manejadorCrearTipoGlamping){
        this.manejadorCrearTipoGlamping = manejadorCrearTipoGlamping;
    }

    @PostMapping
    @ApiOperation("Crear tipo glamping")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTipoGlamping comandoTipoGlamping){
    return manejadorCrearTipoGlamping.ejecutar(comandoTipoGlamping);
    }

}
