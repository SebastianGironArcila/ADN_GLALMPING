package com.ceiba.tipo.comando.fabrica;

import com.ceiba.tipo.modelo.entidad.Tipo;
import com.ceiba.tipo.comando.ComandoTipoGlamping;
import org.springframework.stereotype.Component;

@Component
public class FabricaTipoGlamping {

    public Tipo crear(ComandoTipoGlamping comandoTipoGlamping){
        return new Tipo(
                comandoTipoGlamping.getId(),
                comandoTipoGlamping.getDefinicion(),
                comandoTipoGlamping.getCantPersonasMax()

        );
    }
}
