import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

import { ClaseService } from '@clase/shared/service/clase.service';
import { Curso } from '@curso/shared/model/curso';
import { CursoService } from '@curso/shared/service/curso.service';
import { Docente } from '@docente/shared/model/docente';
import { DocenteService } from '@docente/shared/service/docente.service';

@Component({
  selector: 'app-crear-clase',
  templateUrl: './crear-clase.component.html',
  styleUrls: ['./crear-clase.component.css']
})
export class CrearClaseComponent implements OnInit {

  claseForm: FormGroup;

  listaCursos: Curso[] = [];
  listaDocentes: Docente[] = [];

  flagDocente: boolean = false;
  flagCurso: boolean = false;

  constructor(protected claseService: ClaseService, protected cursoServie:CursoService, 
              protected docenteService: DocenteService, protected router: Router, 
              protected snackBar: MatSnackBar) { }

  ngOnInit() {
    this.construirFormularioClase();
    this.getCursos();
    this.getDocentes();
  }

  getCursos(){
    this.cursoServie.consultar().subscribe( cursos =>{
      if(cursos.length >0){
        this.listaCursos = cursos
        this.flagCurso = true;
      }
    });
  }

  getDocentes(){
    this.docenteService.consultar().subscribe( docentes =>{
      if(docentes.length > 0){
        this.listaDocentes = docentes
        this.flagDocente = true;
      }
    });
  }

  crear(){
    this.claseService.guardar(this.claseForm.value).subscribe(
      () => this.router.navigate(['clase/listar']),
      (error: HttpErrorResponse) => {
        this.snackBarMessage(error.error.mensaje, 2000);
      })
  }

  private construirFormularioClase() {
    this.claseForm = new FormGroup({
      id      : new FormControl(''),
      nombre  : new FormControl('', [Validators.required]),
      curso   : new FormControl('', [Validators.required]),
      docente : new FormControl('', [Validators.required])
    });
  }

  validarCampo(campo: string) {
    if (this.claseForm.touched) {
      if (this.claseForm.get(campo)?.hasError('required')) {
        return `El campo es obligatorio`;
      }
    }
    return;
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
