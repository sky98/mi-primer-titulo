import { Alumno } from '@alumno/shared/model/alumno';
import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-alumno',
  templateUrl: './listar-alumno.component.html',
  styleUrls: ['./listar-alumno.component.css']
})
export class ListarAlumnoComponent implements OnInit {

  public listaAlumnos: Observable<Alumno[]>;

  constructor(protected alumnoService: AlumnoService) { }

  ngOnInit() {
    this.listaAlumnos = this.alumnoService.consultar();
  }

  eliminar(alumno: Alumno){
    this.alumnoService.eliminar(alumno).subscribe(  );
  }

}
