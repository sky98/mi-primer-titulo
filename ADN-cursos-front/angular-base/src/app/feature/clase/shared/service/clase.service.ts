import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

import { Clase } from '../model/clase';
import { HttpService } from '@core/services/http.service';

@Injectable({
  providedIn: 'root'
})
export class ClaseService {

  private BASE_URL_CLASE = `${environment.endpoint}clases`;

  constructor(protected http: HttpService) { }

  consultar(){
    return this.http.doGet<Clase[]>(`${this.BASE_URL_CLASE}`, this.http.optsName('consultar clases'));
  }

  detalleClase(claseId: number){
    return this.http.doGet<Clase>(`${this.BASE_URL_CLASE}/${claseId}`, this.http.optsName('detalles clase'));
  }

  guardar(clase: Clase) {
    return this.http.doPost<Clase, boolean>(this.BASE_URL_CLASE, clase,
                                                this.http.optsName('crear/actualizar clases'));
  }

  eliminar(clase: Clase) {
    return this.http.doDelete<boolean>(`${this.BASE_URL_CLASE}/${clase.id}`,
                                                 this.http.optsName('eliminar clases'));
  }
}
