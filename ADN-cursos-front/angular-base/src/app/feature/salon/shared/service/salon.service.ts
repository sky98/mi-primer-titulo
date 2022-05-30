import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

import { HttpService } from '@core/services/http.service';
import { Salon } from '../model/salon';

@Injectable({
  providedIn: 'root'
})
export class SalonService {

  private BASE_URL_SALON = `${environment.endpoint}salones`;

  constructor(protected http: HttpService) { }

  guardar(salon: Salon) {
    return this.http.doPost<Salon, boolean>(this.BASE_URL_SALON, salon,
                                                this.http.optsName('crear salon'));
  }
}
