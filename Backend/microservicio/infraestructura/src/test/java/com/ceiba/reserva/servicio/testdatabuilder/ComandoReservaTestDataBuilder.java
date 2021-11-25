package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.glamping.servicio.testdatabuilder.ComandoGlampingTestDataBuilder;
import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {

   private Long id;
   private Long idGlamping;
   private String cedula;
   private String nombre;
   private LocalDate fechaEntrada;
   private LocalDate fechaSalida;
   private int cantPersonas;
   private String telefono;
   private Double costoTotal;
   private LocalDateTime fechaRegistro;

   public ComandoReservaTestDataBuilder() {
      idGlamping = Long.valueOf(1);
      cedula = "1116275325";
      nombre = "Sergio Reyes";
      fechaEntrada = LocalDate.now();
      fechaSalida =  LocalDate.now().plusDays(3);
      cantPersonas = 2;
      telefono = "3198755856";
      costoTotal = Double.valueOf(9894444);
      fechaRegistro = LocalDateTime.now();

   }

   public ComandoReservaTestDataBuilder conIdGlamping(Long idGlamping) {
      this.idGlamping = idGlamping;
      return this;

   }

   public ComandoReservaTestDataBuilder conCedula(String cedula) {
      this.cedula = cedula;
      return this;

   }

   public ComandoReservaTestDataBuilder conNombre(String nombre) {
      this.nombre = nombre;
      return this;

   }

   public ComandoReservaTestDataBuilder conFechaEntrada(LocalDate fechaEntrada){
      this.fechaEntrada= fechaEntrada;
      return this;

   }

   public ComandoReservaTestDataBuilder conFechaSalida(LocalDate fechaSalida){
      this.fechaSalida= fechaSalida;
      return this;

   }

   public ComandoReservaTestDataBuilder conCantPersonas(int cantPersonas){
      this.cantPersonas= cantPersonas;
      return this;

   }

   public ComandoReservaTestDataBuilder conTelefono(String telefono){
      this.telefono= telefono;
      return this;

   }

   public ComandoReservaTestDataBuilder conCostoTotal(Double costoTotal){
      this.costoTotal= costoTotal;
      return this;

   }

   public ComandoReservaTestDataBuilder conFechaRegistro(LocalDateTime localDateTime){
      this.fechaRegistro= fechaRegistro;
      return this;

   }

   public ComandoReserva build(){
      return new ComandoReserva(id,cedula,nombre,fechaEntrada,idGlamping,cantPersonas,telefono,fechaSalida,costoTotal,fechaRegistro);
   }

}
