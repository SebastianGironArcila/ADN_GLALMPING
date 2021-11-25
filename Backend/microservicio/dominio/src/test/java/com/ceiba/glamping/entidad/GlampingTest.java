package com.ceiba.glamping.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.glamping.modelo.entidad.Glamping;
import com.ceiba.glamping.servicio.testdatabuilder.GlampingTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlampingTest {

    @Test
    @DisplayName("Deberia crear correctamente el usuario")
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        //act
        Glamping glamping = new GlampingTestDataBuilder().conId(1L).conIdTipoGlamping(1L).conDescripcion("cabaña amoblada")
                .conPrecio(Double.valueOf(44944)).conEstado(1).build();
        //assert
        assertEquals(1, glamping.getId());
        assertEquals(1, glamping.getIdTipoGlamping());
        assertEquals("cabaña amoblada", glamping.getDescripcion());
        assertEquals(44944, glamping.getPrecio());
        assertEquals(1, glamping.getEstado());


    }

    @Test
    void deberiaFallarSinIdTipoGlamping(){
        //arrange
        GlampingTestDataBuilder glampingTestDataBuilder = new GlampingTestDataBuilder().conIdTipoGlamping(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    glampingTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar un identificador de un tipo de glamping");

    }

    @Test
    void deberiaFallarSinDescripcion(){
        //arrange
        GlampingTestDataBuilder glampingTestDataBuilder = new GlampingTestDataBuilder().conDescripcion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    glampingTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la descripcion");

    }

    @Test
    void deberiaFallarSinPrecio(){
        //arrange
        GlampingTestDataBuilder glampingTestDataBuilder = new GlampingTestDataBuilder().conPrecio(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    glampingTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el precio");

    }

    @Test
    void deberiaFallarSinEstado(){
        //arrange
        GlampingTestDataBuilder glampingTestDataBuilder = new GlampingTestDataBuilder().conEstado(-1).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    glampingTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar el estado");

    }



}
