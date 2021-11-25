import { by, element } from "protractor";


export class ReservaTarjetaPage{

    private reservaId = element(by.id('reservaId'));
    private cedula = element(by.id('cedula'));    
    private fechas = element(by.id('fechas'));   
    private idGlamping = element(by.id('idGlamping'));   
    private telefono = element(by.id('telefono'));  
    private costoTotal = element(by.id('costoTotal'));  


    async obtenerReservaId(){
        return this.reservaId.getText();

    }

    async obtenerCedula(){
        return this.cedula.getText();
        
    }


    async obtenerFechas(){
        return this.fechas.getText();

    }

    async obtenerIdGlamping(){
        return this.idGlamping.getText();
    }
    
    async obtenerTelefono(){
        return this.telefono.getText();
    }

    async obtenerCostoTotal(){
        return this.costoTotal.getText();
    }



}