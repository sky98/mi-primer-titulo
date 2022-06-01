import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Alumno } from '../model/alumno';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {

  private BASE_URL_ALUMNO = `${environment.endpoint}personas`;

  constructor(protected http: HttpService) { }

  consultar(){
    return this.http.doGet<Alumno[]>(`${this.BASE_URL_ALUMNO}/alumnos`, this.http.optsName('consultar alumnos'));
  }

  guardar(alumno: Alumno) {
    return this.http.doPost<Alumno, boolean>(this.BASE_URL_ALUMNO, alumno,
                                                this.http.optsName('crear/actualizar alumnos'));
  }

  eliminar(alumno: Alumno) {
    return this.http.doDelete<boolean>(`${this.BASE_URL_ALUMNO}/${alumno.id}`,
                                                 this.http.optsName('eliminar alumnos'));
  }
}
