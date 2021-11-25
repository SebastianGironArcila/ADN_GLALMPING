package com.ceiba.tipo.servicio;

import com.ceiba.tipo.modelo.entidad.Tipo;
import com.ceiba.tipo.puerto.repositorio.RepositorioTipo;
import com.ceiba.tipo.servicio.testdatabuilder.TipoGlampingTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearTipoTest {


    @Test
    @DisplayName("Deberia crear el tipo de glamping de manera correcta")
    void deberiaCrearElTipoGlampingDeManeraCorrecta(){

        Tipo tipo = new TipoGlampingTestDataBuilder().build();
        RepositorioTipo repositorioTipo = Mockito.mock(RepositorioTipo.class);
        Mockito.when(repositorioTipo.crear(tipo)).thenReturn(10L);
        ServicioCrearTipo servicioCrearTipo = new ServicioCrearTipo(repositorioTipo);
        //act
        Long idTipoGlamping = servicioCrearTipo.ejecutar(tipo);
        //assert
        assertEquals(10L,idTipoGlamping);
        Mockito.verify(repositorioTipo, Mockito.times(1)).crear(tipo);


    }




}
