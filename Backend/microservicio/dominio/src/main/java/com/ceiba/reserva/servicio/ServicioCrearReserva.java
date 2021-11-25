package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.glamping.modelo.dto.DtoGlamping;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.tipo.modelo.dto.DtoTipo;

import java.time.DayOfWeek;

public class ServicioCrearReserva {

    private static final String EL_GLAMPING_NO_EXISTE_EN_EL_SISTEMA = "El glamping no esta registrado en el sistema";
    private static final String EL_GLAMPING_ESTA_RESERVADO = "El glamping se encuentra reservado";
    private static final String LA_CANTIDAD_DE_PERSONAS_NO_PUEDE_SUPERAR_EL_LIMITE_DEL_GLAMPING= "La cantidad de personas no puede superar el permitido por el glamping";
    private static final String NO_SE_AGENDAN_RESERVAS_LOS_LUNES = "No se agendan reservas los dias lunes";

    private final RepositorioReserva repositorioReserva;
    private final DaoReserva daoReserva;
    private final ServicioGenerarReserva servicioGenerarReserva;



    public ServicioCrearReserva(RepositorioReserva repositorioReserva, DaoReserva daoReserva, ServicioGenerarReserva servicioGenerarReserva){
        this.repositorioReserva = repositorioReserva;
        this.daoReserva = daoReserva;
        this.servicioGenerarReserva = servicioGenerarReserva;
    }

    public Long ejecutar(Reserva reserva){
        validarLunes(reserva);
        validarExistenciaGlamping(reserva);
        validarEstadoDelGlamping(reserva);
        validarCantidadDePersonas(reserva);
        reserva = this.servicioGenerarReserva.ejecutar(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaGlamping(Reserva reserva){
        boolean existe= this.repositorioReserva.existeGlamping(reserva.getIdGlamping());
        if(!existe){
            throw new ExcepcionValorInvalido(EL_GLAMPING_NO_EXISTE_EN_EL_SISTEMA);
        }
    }



    private void validarCantidadDePersonas(Reserva reserva){
        DtoGlamping dtoGlamping = this.daoReserva.retonarGlampingPorId(reserva.getIdGlamping());
        DtoTipo dtoTipo = this.daoReserva.retonarElTipoDeGlampingPorId(dtoGlamping.getIdTipoGlamping());
        if(reserva.getCantPersonas()> dtoTipo.getCantPersonasMax()){
            throw new ExcepcionValorInvalido(LA_CANTIDAD_DE_PERSONAS_NO_PUEDE_SUPERAR_EL_LIMITE_DEL_GLAMPING);
        }

    }

    private void validarEstadoDelGlamping(Reserva reserva){
        DtoGlamping dtoGlamping =this.daoReserva.retonarGlampingPorId(reserva.getIdGlamping());
        if(dtoGlamping.getEstado()==1){
            throw new ExcepcionValorInvalido(EL_GLAMPING_ESTA_RESERVADO);
        }

    }

    private void validarLunes(Reserva reserva) {
        if (reserva.getFechaRegistro().getDayOfWeek() == DayOfWeek.MONDAY) {
            throw new ExcepcionValorInvalido(NO_SE_AGENDAN_RESERVAS_LOS_LUNES);
        }
    }


}
