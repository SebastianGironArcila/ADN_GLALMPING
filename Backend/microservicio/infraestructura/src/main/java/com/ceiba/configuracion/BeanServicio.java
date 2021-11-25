package com.ceiba.configuracion;

import com.ceiba.glamping.puerto.repositorio.RepositorioGlamping;
import com.ceiba.glamping.servicio.ServicioCrearGlamping;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.reserva.servicio.ServicioGenerarReserva;
import com.ceiba.tipo.puerto.repositorio.RepositorioTipo;
import com.ceiba.tipo.servicio.ServicioCrearTipo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearTipo servicioCrearTipoGlamping(RepositorioTipo repositorioTipo){
        return new ServicioCrearTipo(repositorioTipo);
    }

    @Bean
    public ServicioCrearGlamping servicioCrearGlamping(RepositorioGlamping repositorioGlamping){
        return new ServicioCrearGlamping(repositorioGlamping);
    }

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, DaoReserva daoReserva, ServicioGenerarReserva servicioGenerarReserva){
        return new ServicioCrearReserva(repositorioReserva, daoReserva, servicioGenerarReserva);
    }

    @Bean
    public ServicioGenerarReserva servicioGenerarReserva(DaoReserva daoReserva){
        return new ServicioGenerarReserva(daoReserva);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva){
        return new ServicioEliminarReserva(repositorioReserva);
    }


	

}
