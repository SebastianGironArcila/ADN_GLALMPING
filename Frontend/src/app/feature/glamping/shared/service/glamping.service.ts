import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Glamping } from '../model/glamping';

@Injectable()
export class GlampingService {
  glamping: Glamping;
  
  constructor(protected http: HttpService) { }

  public consultar(){
    return this.http.doGet<Glamping[]>(`${environment.endpoint}/glampings`);
  }
}
