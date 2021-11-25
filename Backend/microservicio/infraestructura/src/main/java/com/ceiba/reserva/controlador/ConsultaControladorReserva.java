package com.ceiba.reserva.controlador;


import com.ceiba.reserva.consulta.ManejadorListarReserva;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador consulta reservas"})
public class ConsultaControladorReserva {

    private final ManejadorListarReserva manejadorListarReserva;

    public ConsultaControladorReserva(ManejadorListarReserva manejadorListarReserva) {
        this.manejadorListarReserva = manejadorListarReserva;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar(){
        return this.manejadorListarReserva.ejecutar();
    }
}
