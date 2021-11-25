import { Injectable } from '@angular/core';
import * as moment from 'moment';

@Injectable({
  providedIn: 'root'
})
export class FormatoFechaService {

  constructor() { }


  obtenerFechaActual() {
    return this.formatearFechaConHora(moment().toDate());
  }

  formatearFechaConHora(fecha: Date) {
    let fechaNueva = moment(fecha).format('YYYY-MM-DD HH:mm:ss');
    return fechaNueva;
  }

  formatearFechaSinHora(fecha: Date) {
    let fechaNueva = moment(fecha).format('YYYY-MM-DD');
    return fechaNueva;
  }
}
