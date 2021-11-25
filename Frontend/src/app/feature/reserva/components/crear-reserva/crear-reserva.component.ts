import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ReservaService } from '../../shared/service/reserva.service';
import { Observable } from 'rxjs';
import { Tipo } from '../../shared/model/tipo';
import { Glamping } from 'src/app/feature/glamping/shared/model/glamping';
import { SwalService } from '@core/services/swal.service';
import { Router } from '@angular/router';
import { GlampingService } from '../../../glamping/shared/service/glamping.service';
import { FormatoFechaService } from '../../../../shared/services/formato-fecha.service';
import * as moment from 'moment';

@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html',
  styleUrls: ['./crear-reserva.component.css']
})
export class CrearReservaComponent implements OnInit {
  public listaTiposGlamping: Observable<Tipo[]>;
  public listaGlamping: Observable<Glamping[]>;
  reservaForm: FormGroup;  

  tiposGlamping: Tipo[]=[];
  glamping: Glamping[]=[];

  constructor(
    protected reservaService: ReservaService,
    protected glampingService: GlampingService,
    protected swalService: SwalService,
    protected router:Router,
    protected formatoFechaService: FormatoFechaService
    ) { }

  ngOnInit(){
    this.listaGlamping =this.glampingService.consultar();

  
    this.listaGlamping.subscribe((data:Glamping[])=>{
      this.glamping=[...data];
      
    })

    this.construirFormularioReserva();
    
  }



  private construirFormularioReserva(){
    this.reservaForm = new FormGroup({
        id: new FormControl(0),
        cedula: new FormControl('', [Validators.required]),
        nombre: new FormControl('', [Validators.required]),
        fechaEntrada: new FormControl('', [Validators.required]),
        idGlamping: new FormControl('', [Validators.required]),
        cantPersonas: new FormControl('', [Validators.required]),
        telefono: new FormControl('', [Validators.required]),
        fechaSalida: new FormControl('', [Validators.required]),
        costoTotal: new FormControl(1),
        fechaRegistro: new FormControl('')
        
    })
  }


  guardar(){
 
    this.reservaForm.value.fechaRegistro = this.formatoFechaService.obtenerFechaActual();
    this.reservaForm.value.fechaEntrada = this.formatoFechaService.formatearFechaSinHora(moment(this.reservaForm.value.fechaEntrada).toDate());
    this.reservaForm.value.fechaSalida = this.formatoFechaService.formatearFechaSinHora(moment(this.reservaForm.value.fechaSalida).toDate());
    this.reservaForm.value.telefono = String(this.reservaForm.value.telefono);
    this.reservaForm.value.idGlamping = this.reservaForm.value.idGlamping.id;
    console.log(this.reservaForm.value);
    this.reservaService.guardar(this.reservaForm.value).subscribe(
      () => {
        this.swalService.succes("Reserva creada correctamente");
      
        this.router.navigate(["/reserva/listar"]);
        
      },
      (error) => {
        this.swalService.danger(error.error.mensaje);
        
      }
    );
  }
  




}
