package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReservaTest {

    @Test
    @DisplayName("Deberia crear correctamente la reserva")
    void deberiaCrearCorrectamenteLaReserva(){
        //arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDate fechaEntrada = LocalDate.now();
        LocalDate fechaSalida = LocalDate.now().plusDays(3);

        //act
        Reserva reserva = new ReservaTestDataBuilder()
                .conId(1L)
                .conIdGlamping(1L)
                .conCedula("1116275325")
                .conNombre("Duvan")
                .conFechaEntrada(fechaEntrada)
                .conFechaSalida(fechaSalida)
                .conCantPersonas(2)
                .conTelefono("3198755856")
                .conCostoTotal(Double.valueOf(9894444))
                .conFechaRegistro(fechaCreacion)
                .build();
        //assert
        assertEquals(1,reserva.getId());
        assertEquals(1,reserva.getIdGlamping());
        assertEquals("1116275325",reserva.getCedula());
        assertEquals("Duvan",reserva.getNombre());
        assertEquals(fechaEntrada,reserva.getFechaEntrada());
        assertEquals(fechaSalida,reserva.getFechaSalida());
        assertEquals(2,reserva.getCantPersonas());
        assertEquals("3198755856",reserva.getTelefono());
        assertEquals(fechaCreacion,reserva.getFechaRegistro().withNano(fechaCreacion.getNano()));


    }

    @Test
    void deberiaFallarSinIdGlamping(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdGlamping(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar un identificador de un glamping");

    }

    @Test
    void deberiaFallarSinCedula(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCedula(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cedula");

    }

    @Test
    void deberiaFallarSinNombre(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conNombre(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre");

    }

    @Test
    void deberiaFallarSinFechaEntrada(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaEntrada(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de entrada");

    }

    @Test
    void deberiaFallarSinFechaSalida(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaSalida(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de salida");

    }

    @Test
    void deberiaFallarSinCantPersonas(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCantPersonas(0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar la cantidad de personas");

    }

    @Test
    void deberiaFallarSinTelefono(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conTelefono(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el numero telefonico");

    }

    @Test
    void deberiaFallarSinCostoTotal(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCostoTotal(0).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "Se debe ingresar el costo total");

    }

    @Test
    void deberiaFallarSinFechaRegistro(){

        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaRegistro(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de registro");

    }
















}
