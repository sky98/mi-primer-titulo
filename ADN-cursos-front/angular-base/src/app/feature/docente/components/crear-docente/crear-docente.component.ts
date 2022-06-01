import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

import { DocenteService } from '@docente/shared/service/docente.service';

const LONGITUD_MINIMA_IDENTIFICACION = 4;

@Component({
  selector: 'app-crear-docente',
  templateUrl: './crear-docente.component.html',
  styleUrls: ['./crear-docente.component.css']
})
export class CrearDocenteComponent implements OnInit {

  docenteForm: FormGroup;

  constructor(protected docenteService: DocenteService, protected router: Router,
    protected snackBar: MatSnackBar) { }

  ngOnInit() {
    this.construirFormularioDocente();
  }

  validarCampo(campo: string) {
    if (this.docenteForm.touched) {
      if (this.docenteForm.get(campo)?.hasError('required')) {
        return `El campo es obligatorio`
      }else if(this.docenteForm.get(campo)?.hasError('minlength')){
        return `longitud minima de ${LONGITUD_MINIMA_IDENTIFICACION}`;
      }
    }
    return;
  }

  crear(){
    this.docenteService.guardar(this.docenteForm.value).subscribe(
      () => this.router.navigate(['docente/listar']),
      (error: HttpErrorResponse) => {
        this.snackBarMessage(error.error.mensaje, 2000);
      }
    );
  }

  private construirFormularioDocente() {
    this.docenteForm = new FormGroup({
      id: new FormControl(''),
      identificacion: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_IDENTIFICACION)]),
      nombre: new FormControl('', [Validators.required]),
      apellido: new FormControl('', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      correoElectronico: new FormControl('', [Validators.required])
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
