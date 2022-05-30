import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';

import { Dias, Horario } from '../model/horario';

const DIAS: Dias[] = [
  {id: 1, nombre: 'Lunes'},
  {id: 2, nombre: 'Martes'},
  {id: 3, nombre: 'Miercoles'},
  {id: 4, nombre: 'Jueves'},
  {id: 5, nombre: 'Viernes'}
];

@Injectable({
  providedIn: 'root'
})
export class HorarioService {

  respDia: string = '';

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

  getDias(): Dias[]{
    return DIAS;
  }

  getDia(id: number): string{
    DIAS.forEach(element => {
      if(element.id == id){
        this.respDia = element.nombre;
      }
    });
    return this.respDia;
  }
  
}
