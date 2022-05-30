import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Clase } from '@clase/shared/model/clase';
import { ClaseService } from '@clase/shared/service/clase.service';

import { HorarioService } from '@horario/shared/service/horario.service';


@Component({
  selector: 'app-crear-horario',
  templateUrl: './crear-horario.component.html',
  styleUrls: ['./crear-horario.component.css']
})
export class CrearHorarioComponent implements OnInit {

  dias = [
    {id: 1, nombre: 'Lunes'},
    {id: 2, nombre: 'Martes'},
    {id: 3, nombre: 'Miercoles'},
    {id: 4, nombre: 'Jueves'},
    {id: 5, nombre: 'Viernes'}
  ];

  horas = [
    {id: 8, nombre: "8 AM"},
    {id: 9, nombre: "9 AM"},
    {id: 10, nombre: "10 AM"},
    {id: 11, nombre: "11 AM"},
    {id: 14, nombre: "14 PM"},
    {id: 15, nombre: "15 PM"},
    {id: 16, nombre: "16 PM"},
    {id: 17, nombre: "17 PM"}
  ];

  cantidadHoras = [
    {id: 4, nombre: 4},
    {id: 3, nombre: 3},
    {id: 2, nombre: 2},
    {id: 1, nombre: 1}
  ];

  controlHoras = [
    {id: 4, nombre: 4},
    {id: 3, nombre: 3},
    {id: 2, nombre: 2},
    {id: 1, nombre: 1}
  ];

  horarioForm: FormGroup;

  listaClases: Clase[] = [];
  flagClases: boolean = false;

  constructor(private horarioService: HorarioService, private router: Router, private snackBar: MatSnackBar, private claseService: ClaseService) { }

  ngOnInit() {
    this.construirFormularioHorario();
    this.getClases();
  }

  selectHoraInicio(valor: number){
    if(valor == 8 || valor == 14){
      this.deshabilitarOpcionesEnLosNumerosDeHoras(5);
    } else if(valor == 9 || valor == 15){
      this.deshabilitarOpcionesEnLosNumerosDeHoras(4);
    } else if(valor == 10 || valor == 16){
      this.deshabilitarOpcionesEnLosNumerosDeHoras(3);
    } else if(valor == 11 || valor == 17){
      this.deshabilitarOpcionesEnLosNumerosDeHoras(2);
    }
    this.horarioForm.controls['cantidadHoras'].setValue(null);
    this.horarioForm.controls['cantidadHoras'].enable();
  }

  deshabilitarOpcionesEnLosNumerosDeHoras(valor: number){
    this.cantidadHoras = this.controlHoras.filter(x => x.id<valor);
  }

  getClases(){
    this.claseService.consultar().subscribe( clases =>{
      if(clases.length>0){
        this.listaClases = clases;
        this.flagClases = true;
      }
    });
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
      dia           : new FormControl('', [Validators.required]),
      horaInicio    : new FormControl('', [Validators.required]),
      cantidadHoras : new FormControl({value:'', disabled: true}, [Validators.required])
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
