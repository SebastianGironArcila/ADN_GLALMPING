package com.ceiba.glamping.comando.manejador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.glamping.comando.ComandoGlamping;
import com.ceiba.glamping.comando.fabrica.FabricaGlamping;
import com.ceiba.glamping.modelo.entidad.Glamping;
import com.ceiba.glamping.servicio.ServicioCrearGlamping;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearGlamping implements ManejadorComandoRespuesta<ComandoGlamping, ComandoRespuesta<Long>>{

    private final FabricaGlamping fabricaGlamping;
    private final ServicioCrearGlamping servicioCrearGlamping;

    public ManejadorCrearGlamping(FabricaGlamping fabricaGlamping, ServicioCrearGlamping servicioCrearGlamping) {
        this.fabricaGlamping = fabricaGlamping;
        this.servicioCrearGlamping = servicioCrearGlamping;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoGlamping comandoGlamping){
        Glamping glamping = this.fabricaGlamping.crear(comandoGlamping);
        return new ComandoRespuesta<>(this.servicioCrearGlamping.ejecutar(glamping));

    }
}
