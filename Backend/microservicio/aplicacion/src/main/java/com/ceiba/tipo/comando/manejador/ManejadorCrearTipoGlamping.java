package com.ceiba.tipo.comando.manejador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.tipo.comando.fabrica.FabricaTipoGlamping;
import com.ceiba.tipo.modelo.entidad.Tipo;
import com.ceiba.tipo.servicio.ServicioCrearTipo;
import com.ceiba.tipo.comando.ComandoTipoGlamping;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTipoGlamping implements ManejadorComandoRespuesta<ComandoTipoGlamping, ComandoRespuesta<Long>> {

    private final FabricaTipoGlamping fabricaTipoGlamping;
    private final ServicioCrearTipo servicioCrearTipo;

    public ManejadorCrearTipoGlamping(FabricaTipoGlamping fabricaTipoGlamping, ServicioCrearTipo servicioCrearTipo){
        this.fabricaTipoGlamping = fabricaTipoGlamping;
        this.servicioCrearTipo = servicioCrearTipo;

    }

    public ComandoRespuesta<Long> ejecutar(ComandoTipoGlamping comandoTipoGlamping){
        Tipo tipo = this.fabricaTipoGlamping.crear(comandoTipoGlamping);
        return new ComandoRespuesta<>(this.servicioCrearTipo.ejecutar(tipo));


    }



}
