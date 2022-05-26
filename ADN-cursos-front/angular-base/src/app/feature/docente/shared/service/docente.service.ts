import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

import { Docente } from '../model/docente';
import { HttpService } from '@core/services/http.service';

@Injectable({
  providedIn: 'root'
})
export class DocenteService {

  private BASE_URL_DOCENTE = `${environment.endpoint}personas`;

  constructor(protected http: HttpService) { }

  consultar(){
    return this.http.doGet<Docente[]>(`${this.BASE_URL_DOCENTE}/listar-docentes`, this.http.optsName('consultar docentes'));
  }

  guardar(docente: Docente) {
    return this.http.doPost<Docente, boolean>(this.BASE_URL_DOCENTE, docente,
                                                this.http.optsName('crear/actualizar docentes'));
  }

  eliminar(docente: Docente) {
    return this.http.doDelete<boolean>(`${this.BASE_URL_DOCENTE}/${docente.id}`,
                                                 this.http.optsName('eliminar docentes'));
  }
}
