import { Component, OnInit } from '@angular/core';

import { Alumno } from '@alumno/shared/model/alumno';
import { AlumnoService } from '@alumno/shared/service/alumno.service';

@Component({
  selector: 'app-listar-alumno',
  templateUrl: './listar-alumno.component.html',
  styleUrls: ['./listar-alumno.component.css']
})
export class ListarAlumnoComponent implements OnInit {

  public listaAlumnos: Alumno[] = [];

  flagAlumnos: boolean = true

  constructor(protected alumnoService: AlumnoService) { }

  ngOnInit() {
    this.alumnoService.consultar().subscribe( alumnos =>{
      (alumnos.length>0)?this.listaAlumnos=alumnos: this.flagAlumnos = false
    });
  }

  eliminar(alumno: Alumno){
    this.alumnoService.eliminar(alumno).subscribe( ()=> {
      this.listaAlumnos = this.listaAlumnos.filter(x => x.id!=alumno.id);
      (this.listaAlumnos.length<1)?this.flagAlumnos=false:'';
    });
  }

}
