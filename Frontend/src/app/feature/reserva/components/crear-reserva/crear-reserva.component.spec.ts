import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CrearReservaComponent } from './crear-reserva.component';
import { MaterialModule } from '../../../../core/material.module';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReservaService } from '../../shared/service/reserva.service';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs';
import { SwalService } from '../../../../core/services/swal.service';
import { HttpClientModule } from '@angular/common/http';
import { GlampingService } from '../../../glamping/shared/service/glamping.service';
import { RouterTestingModule } from '@angular/router/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Glamping } from '../../../glamping/shared/model/glamping';
import { FormatoFechaService } from '../../../../shared/services/formato-fecha.service';





describe('CrearReservaComponent', () => {
  let component: CrearReservaComponent;
  let fixture: ComponentFixture<CrearReservaComponent>;
  let reservaService: ReservaService;
  let glampingService: GlampingService;
  let swalServivce: SwalService;
 

  const glampingLista: Glamping[] = [new Glamping(1,1,'cabaña con tina',200000,1),
                                  new Glamping(1,1,'cabaña con tina',200000,1)];

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearReservaComponent ],
      imports: [
        CommonModule,
        MaterialModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        RouterTestingModule,
        BrowserAnimationsModule
      ],
      providers: [ReservaService, HttpService, SwalService, GlampingService, FormatoFechaService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    glampingService = TestBed.inject(GlampingService);
    swalServivce = TestBed.inject(SwalService);
  
    spyOn(glampingService,'consultar').and.returnValue(
        of(glampingLista)
    );
    spyOn(reservaService, 'guardar').and.returnValue(
      of(true)
    );
    spyOn(swalServivce,'succes');
    fixture.detectChanges();
  });
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.reservaForm.valid).toBeFalsy();
  });

  
  it('Registrando reserva', () => {
    expect(component.reservaForm.valid).toBeFalsy();
    component.reservaForm.controls.id.setValue(0);
    component.reservaForm.controls.cedula.setValue('1116275325');
    component.reservaForm.controls.nombre.setValue('Sebastian Giron');
    component.reservaForm.controls.fechaEntrada.setValue('2020-02-01');
    component.reservaForm.controls.idGlamping.setValue(1);
    component.reservaForm.controls.cantPersonas.setValue(2);
    component.reservaForm.controls.telefono.setValue('3053198749');
    component.reservaForm.controls.fechaSalida.setValue('2020-02-01');    
    component.reservaForm.controls.costoTotal.setValue(1);
    component.reservaForm.controls.fechaRegistro.setValue('2020-02-01 08:00:00');
    expect(component.reservaForm.valid).toBeTruthy();

    component.guardar();

   
    expect(component.reservaForm.value.cedula).toBe('1116275325');
    expect(component.reservaForm.value.nombre).toBe('Sebastian Giron')
    expect(component.reservaForm.value.fechaEntrada).toBe('2020-02-01');
    expect(component.reservaForm.value.cantPersonas).toBe(2);
    expect(component.reservaForm.value.telefono).toBe('3053198749');
    expect(component.reservaForm.value.fechaSalida).toBe('2020-02-01');
    expect(swalServivce.succes).toHaveBeenCalledTimes(1);
    
   







  });




  

 

});
