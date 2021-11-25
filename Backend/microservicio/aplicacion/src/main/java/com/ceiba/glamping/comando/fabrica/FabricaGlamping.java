package com.ceiba.glamping.comando.fabrica;


import com.ceiba.glamping.comando.ComandoGlamping;
import com.ceiba.glamping.modelo.entidad.Glamping;
import org.springframework.stereotype.Component;

@Component
public class FabricaGlamping {

    public Glamping crear(ComandoGlamping comandoGlamping){
        return new Glamping(
                comandoGlamping.getId(),
                comandoGlamping.getIdTipoGlamping(),
                comandoGlamping.getDescripcion(),
                comandoGlamping.getPrecio(),
                comandoGlamping.getEstado()
        );
    }
}
