import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

import { SalonService } from '../../shared/service/salon.service';

import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { Alumno } from '@alumno/shared/model/alumno';
import { Curso } from '@curso/shared/model/curso';
import { CursoService } from '@curso/shared/service/curso.service';

@Component({
  selector: 'app-crear-salon',
  templateUrl: './crear-salon.component.html',
  styleUrls: ['./crear-salon.component.css']
})
export class CrearSalonComponent implements OnInit {

  salonForm: FormGroup;

  flagAlumno: boolean = false;
  flagCurso: boolean = false;

  listaAlumnos: Alumno[] = [];
  listaCursos: Curso[] = [];


  constructor(private salonService: SalonService, private snackBar: MatSnackBar, private alumnoService: AlumnoService, private cursoService: CursoService) { }

  ngOnInit() {
    this.construirFormularioSalon();
    this.cargarAlumnos();
    this.cargarCursos();    
  }

  cargarAlumnos(){
    this.alumnoService.consultar().subscribe(alumnos =>{
      if(alumnos.length > 0){
        this.listaAlumnos = alumnos;
        this.flagAlumno = true;
      }
    });
  }

  private cargarCursos(){
    this.cursoService.consultar().subscribe(cursos =>{
      if(cursos.length > 0){
        this.listaCursos = cursos
        this.flagCurso = true
      }
    });
  }

  validarCampo(campo: string) {
    if (this.salonForm.touched) {
      if (this.salonForm.get(campo)?.hasError('required')) {
        return `El campo es obligatorio`;
      } 
    }
    return;
  }

  crear(){
    this.salonService.guardar(this.salonForm.value).subscribe(
      /*() => this.router.navigate(['curso/listar']),
      (error: HttpErrorResponse) => {
        this.snackBarMessage(error.error.mensaje, 2000);
      }*/
      ()=>this.snackBarMessage('Registro Creado')
    );
  }

  private construirFormularioSalon() {
    this.salonForm = new FormGroup({
      id      : new FormControl(''),
      alumno  : new FormControl('', [Validators.required]),
      curso   : new FormControl('', [Validators.required])
    });
  }

  private snackBarMessage(
    message: string,
    duration: number = 1500,
    horizontalPosition: MatSnackBarHorizontalPosition = 'center',
    verticalPosition: MatSnackBarVerticalPosition = 'top') {

    this.snackBar.open(message, '', {
      duration,
      horizontalPosition,
      verticalPosition
    })
  }

}
