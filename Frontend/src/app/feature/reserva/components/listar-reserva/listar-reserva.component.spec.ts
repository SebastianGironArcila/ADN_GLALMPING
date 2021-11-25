import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ListarReservaComponent } from './listar-reserva.component';
import { ReservaService } from '../../shared/service/reserva.service';
import { Reserva } from '../../shared/model/reserva';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs';

describe('ListarReservaComponent', () => {
  let component: ListarReservaComponent;
  let fixture: ComponentFixture<ListarReservaComponent>;
  let reservaService: ReservaService;
  const listaReservas: Reserva[] = [new Reserva(1,'1116275325','Sebastian','2020-02-09',1,4,'3053198749','2020-02-11',250000,'2020-02-01 08:05:30'),
                                    new Reserva(2,'1116275325','Carlos','2020-02-09',2,3,'3053198749','2020-02-11',480000,'2020-02-01 08:05:30')]

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ListarReservaComponent],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [ReservaService, HttpService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    spyOn(reservaService,'consultar').and.returnValue(
        of(listaReservas)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.listaReservas.subscribe(resultado=>{
        expect(2).toBe(resultado.length);
    })
  });
});
