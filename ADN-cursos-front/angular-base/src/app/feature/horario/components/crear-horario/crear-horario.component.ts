import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

import { HorarioService } from '@horario/shared/service/horario.service';

const HORAS_MAÑANA = '([8-11])';
const HORAS_TARDE = '([14-17])';
const DIAS_ADMITIDOS = '([1-5])';
const CANTIDAD_HORAS = '([1-5])';

@Component({
  selector: 'app-crear-horario',
  templateUrl: './crear-horario.component.html',
  styleUrls: ['./crear-horario.component.css']
})
export class CrearHorarioComponent implements OnInit {

  dia = [
    {id: 1, nombre: 'Lunes'},
    {id: 2, nombre: 'Martes'},
    {id: 3, nombre: 'Miercoles'},
    {id: 4, nombre: 'Jueves'},
    {id: 5, nombre: 'Viernes'}
  ];

  horarioForm: FormGroup;

  constructor(private horarioService: HorarioService, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.construirFormularioHorario();
  }

  validarCampo(campo: string) {
    if (this.horarioForm.touched) {
      if (this.horarioForm.get(campo)?.hasError('required')) {
        return `El campo es obligatorio`
      }else if(this.horarioForm.get(campo)?.hasError('pattern')){
        return `Valor invalido`;
      }
    }
    return;
  }

  crear(){
    this.horarioService.guardar(this.horarioForm.value).subscribe(
      () => this.router.navigate(['horario/listar']),
      (error: HttpErrorResponse) => {
        this.snackBarMessage(error.error.mensaje, 2000);
      }
    );
  }

  private construirFormularioHorario() {
    this.horarioForm = new FormGroup({
      id            : new FormControl(''),
      clase         : new FormControl('', [Validators.required]),
      dia           : new FormControl('', [Validators.required, Validators.pattern(DIAS_ADMITIDOS)]),
      horaInicio    : new FormControl('', [Validators.required, Validators.pattern(HORAS_MAÑANA), Validators.pattern(HORAS_TARDE)]),
      cantidadHoras : new FormControl('', [Validators.required, Validators.pattern(CANTIDAD_HORAS)])
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
