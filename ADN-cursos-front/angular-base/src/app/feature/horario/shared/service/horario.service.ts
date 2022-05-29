import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Horario } from '../model/horario';

@Injectable({
  providedIn: 'root'
})
export class HorarioService {

  private BASE_URL_HORARIO = `${environment.endpoint}horarios`;

  constructor(private http: HttpService) { }

  consultar(){
    return this.http.doGet<Horario[]>(this.BASE_URL_HORARIO, this.http.optsName('consultar Horarios'));
  }

  guardar(horario: Horario) {
    return this.http.doPost<Horario, boolean>(this.BASE_URL_HORARIO, horario,
                                                this.http.optsName('crear Horarios'));
  }

  eliminar(horario: Horario) {
    return this.http.doDelete<boolean>(`${this.BASE_URL_HORARIO}/${horario.id}`,
                                                 this.http.optsName('eliminar Horarios'));
  }
}
