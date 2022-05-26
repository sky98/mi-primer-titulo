import { Component, OnInit } from '@angular/core';

import { Alumno } from '@alumno/shared/model/alumno';
import { AlumnoService } from '@alumno/shared/service/alumno.service';

@Component({
  selector: 'app-listar-alumno',
  templateUrl: './listar-alumno.component.html',
  styleUrls: ['./listar-alumno.component.css'],
})
export class ListarAlumnoComponent implements OnInit {

  dataSource: Alumno[] = [];
  flagAlumnos: boolean = false;
  displayedColumns = ['identificacion', 'nombres', 'direccion', 'telefono', 'accion'];

  constructor(protected alumnoService: AlumnoService) { }

  ngOnInit() {
    this.alumnoService.consultar().subscribe( alumnos =>{
      if(alumnos.length>0){
        this.dataSource = alumnos;
        this.flagAlumnos = true;
      }
    });
  }

  eliminar(alumno: Alumno){
    this.alumnoService.eliminar(alumno).subscribe( ()=> {
      this.dataSource = this.dataSource.filter(x => x.id!=alumno.id);
      (this.dataSource.length<1)?this.flagAlumnos=false:this.flagAlumnos=true;
    });
  }

}
