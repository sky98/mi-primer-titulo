import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { CursoService } from '@curso/shared/service/curso.service';

import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

const LONGITUD_ADMITIDAS_HORAS = '([1-4])';

@Component({
  selector: 'app-crear-curso',
  templateUrl: './crear-curso.component.html',
  styleUrls: ['./crear-curso.component.css']
})
export class CrearCursoComponent implements OnInit {

  cursoForm: FormGroup;

  constructor(protected cursoService: CursoService, protected router: Router, protected snackBar: MatSnackBar) { }

  ngOnInit() {
    this.construirFormularioCurso();
  }

  validarCampo(campo: string) {
    if (this.cursoForm.touched) {
      if (this.cursoForm.get(campo)?.hasError('required')) {
        return `El campo es obligatorio`;
      } else if (this.cursoForm.get(campo)?.hasError('pattern')) {
        return `Debe ingresar un valor mayor a 1 y menor a 5`;
      }
    }
    return;
  }

  crear(){
    this.cursoService.guardar(this.cursoForm.value).subscribe(
      () => this.router.navigate(['curso/listar']),
      (error: HttpErrorResponse) => {
        this.snackBarMessage(error.error.mensaje, 2000);
      }
    );
  }

  private construirFormularioCurso() {
    this.cursoForm = new FormGroup({
      id: new FormControl(''),
      identificacion: new FormControl(''),
      nombre: new FormControl('', [Validators.required]),
      descripcion: new FormControl('', [Validators.required]),
      horas: new FormControl('', [Validators.required,Validators.pattern(LONGITUD_ADMITIDAS_HORAS)])
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
