import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ReservaService } from './reserva.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/services/http.service';
import { Reserva } from '../model/reserva';
import { HttpResponse } from '@angular/common/http';


describe('ReservaService', () => {
  let httpMock: HttpTestingController;
  let service: ReservaService;
  
  const apiEndpointReservaConsulta = `${environment.endpoint}/reservas`;
  const apiEndpointReserva = `${environment.endpoint}/reserva`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ReservaService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(ReservaService);
  });

  it('should be created', () => {
    const reservaService: ReservaService = TestBed.inject(ReservaService);
    expect(reservaService).toBeTruthy();
  });

  it('deberia listar las reservas', () =>{

    const dummyReservas = [
      new Reserva(1,'1116275325','Sebastian','2020-02-09',1,4,'3053198749','2020-02-11',250000,'2020-02-01 08:05:30'),
      new Reserva(2,'1116275325','Carlos','2020-02-09',2,3,'3053198749','2020-02-11',480000,'2020-02-01 08:05:30')
    ];
    service.consultar().subscribe(reservas =>{
      expect(reservas.length).toBe(2);
      expect(reservas).toEqual(dummyReservas);
    });
    const req = httpMock.expectOne(apiEndpointReservaConsulta);
    expect(req.request.method).toBe('GET');
    req.flush(dummyReservas);
  });

  it('deberia crear una reserva', () => {
    const dummyReserva = new Reserva(1,'1116275325','Sebastian','2020-02-09',1,4,'3053198749','2020-02-11',250000,'2020-02-01 08:05:30')
    service.guardar(dummyReserva).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointReserva);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));

  });

  it('deberia eliminar una reserva', () => {
    const dummyReserva =new Reserva(1,'1116275325','Sebastian','2020-02-09',1,4,'3053198749','2020-02-11',250000,'2020-02-01 08:05:30');
    service.eliminar(dummyReserva).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpointReserva}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({body: true}));
  });

});
