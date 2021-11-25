import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { GlampingService } from './glamping.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/services/http.service';
import { Glamping } from '../model/glamping';


describe('GlampingService', () => {
  let httpMock: HttpTestingController;
  let service: GlampingService;
  const apiEndpointGlampingConsulta = `${environment.endpoint}/glampings`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [GlampingService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(GlampingService);
  });

  it('should be created', () => {
    const glampingService: GlampingService = TestBed.inject(GlampingService);
    expect(glampingService).toBeTruthy();
  });

  it('deberia listar los glamping', () =>{

    const dummyReservas = [
      new Glamping(1,1,'Cabaña amoblada para una familia, wifi, recreacion y una tina grande con agua caliente',500000,0),
      new Glamping(2,2,'Cabaña amoblada para una pareja, wifi, recreacion y una tina pequeña con agua caliente',100000,0)
    ];
    service.consultar().subscribe(glamping =>{
      expect(glamping.length).toBe(2);
      expect(glamping).toEqual(dummyReservas);
    });
    const req = httpMock.expectOne(apiEndpointGlampingConsulta);
    expect(req.request.method).toBe('GET');
    req.flush(dummyReservas);
  });
  

});
