import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Reserva } from '@reserva/shared/model/reserva';
import { ReservaService } from '../../shared/service/reserva.service';
import { SwalService } from '../../../../core/services/swal.service';

@Component({
  selector: 'app-tarjeta-reserva',
  templateUrl: './tarjeta-reserva.component.html',
  styleUrls: ['./tarjeta-reserva.component.css']
})
export class TarjetaReservaComponent implements OnInit {

  @Input() reserva: Reserva;

  @Output() eliminar = new EventEmitter<Reserva>();
  
  constructor(
    protected service: ReservaService,
    protected swalService: SwalService
  ) { }

  ngOnInit(): void {
  }

  eliminarReserva(){
   this.eliminar.emit(this.reserva);
  }

}
