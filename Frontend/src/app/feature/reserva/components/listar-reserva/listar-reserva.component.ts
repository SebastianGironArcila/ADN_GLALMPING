import { Component, OnInit} from '@angular/core';
import { Reserva } from '@reserva/shared/model/reserva';
import { Observable } from 'rxjs';
import { ReservaService } from '@reserva/shared/service/reserva.service';
import { SwalService } from '../../../../core/services/swal.service';



@Component({
  selector: 'app-listar-reserva',
  templateUrl: './listar-reserva.component.html',
  styleUrls: ['./listar-reserva.component.css']
})
export class ListarReservaComponent implements OnInit {

  public listaReservas: Observable<Reserva[]>;


  reservas: Reserva[] = [];

  constructor(
    protected reservaService: ReservaService,
    protected swalService:SwalService
    ) {
    
   }

  ngOnInit(){
    this.listarReservas();
  }

  listarReservas(){
    this.listaReservas = this.reservaService.consultar();
  }

  eliminarReserva(reserva: Reserva){
    this.reservaService.eliminar(reserva).subscribe(()=>{
      this.swalService.danger('Reserva eliminada correctamente');
      this.listarReservas();
    }, fail => {
      this.swalService.error('No se pudo eliminar la reserva ', fail.error.message);
    });
  }

}
