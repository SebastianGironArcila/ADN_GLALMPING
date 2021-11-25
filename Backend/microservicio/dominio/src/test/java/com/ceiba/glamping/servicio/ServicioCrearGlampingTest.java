package com.ceiba.glamping.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.glamping.modelo.entidad.Glamping;
import com.ceiba.glamping.puerto.repositorio.RepositorioGlamping;
import com.ceiba.glamping.servicio.testdatabuilder.GlampingTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearGlampingTest {

    @Test
    @DisplayName("Deberia Crear el glamping de manera correcta")
    void deberiaCrearElGlampingDeManeraCorrecta() {
        //arrange
        Glamping glamping = new GlampingTestDataBuilder().build();
        RepositorioGlamping repositorioGlamping = Mockito.mock(RepositorioGlamping.class);
        Mockito.when(repositorioGlamping.crear(glamping)).thenReturn(10L);
        Mockito.when(repositorioGlamping.existeTipoGlamping(glamping.getIdTipoGlamping())).thenReturn(true);
        ServicioCrearGlamping servicioCrearGlamping = new ServicioCrearGlamping(repositorioGlamping);
        //act
        Long idGlamping = servicioCrearGlamping.ejecutar(glamping);
        //assert
        assertEquals(10L,idGlamping);
        Mockito.verify(repositorioGlamping,Mockito.times(1)).crear(glamping);

    }

    @Test
    @DisplayName("Deberia de lanzar una excepcion cuando no exista ese tipo de glamping")
    void deberiaLanzarUnaExcepcionCuandoNoExistaEseTipoDeGlamping(){
        //arrange
        Glamping glamping = new GlampingTestDataBuilder().conIdTipoGlamping(2L).build();
        RepositorioGlamping repositorioGlamping = Mockito.mock(RepositorioGlamping.class);
        Mockito.when(repositorioGlamping.crear(glamping)).thenReturn(10L);
        Mockito.when(repositorioGlamping.existeTipoGlamping(Mockito.anyLong())).thenReturn(false);
        ServicioCrearGlamping servicioCrearGlamping = new ServicioCrearGlamping(repositorioGlamping);
        //act-assert
        BasePrueba.assertThrows(() -> servicioCrearGlamping.ejecutar(glamping), ExcepcionValorInvalido.class,"El tipo de glamping no esta registrado en el sistema");

    }


}
