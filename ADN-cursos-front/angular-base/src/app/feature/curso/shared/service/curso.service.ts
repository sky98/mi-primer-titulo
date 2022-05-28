import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Curso } from '../model/curso';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private BASE_URL_CURSO = `${environment.endpoint}cursos`;

  constructor(protected http: HttpService) { }

  consultar(){
    return this.http.doGet<Curso[]>(this.BASE_URL_CURSO, this.http.optsName('consultar cursos'));
  }

  obtenerCurso(id: number){
    return this.http.doGet<Curso>(`${this.BASE_URL_CURSO}/${id}`, this.http.optsName('obtener curso'));
  }

  public guardar(curso: Curso) {
    return this.http.doPost<Curso, boolean>(this.BASE_URL_CURSO, curso,
                                                this.http.optsName('crear/actualizar cursos'));
  }

  public eliminar(curso: Curso) {
    return this.http.doDelete<boolean>(`${this.BASE_URL_CURSO}/${curso.id}`,
                                                 this.http.optsName('eliminar cursos'));
  }
}
