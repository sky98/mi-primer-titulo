import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { AlumnoService } from '@alumno/shared/service/alumno.service';

const LONGITUD_MINIMA_IDENTIFICACION = 4;

@Component({
  selector: 'app-crear-alumno',
  templateUrl: './crear-alumno.component.html',
  styleUrls: ['./crear-alumno.component.css']
})
export class CrearAlumnoComponent implements OnInit {

  alumnoForm: FormGroup;

  constructor( protected alumnoService: AlumnoService, protected router: Router ) { }

  ngOnInit() {
    this.construirFormularioAlumno()
  }

  validarCampo(campo: string){
    if(this.alumnoForm.touched){
      if(this.alumnoForm.get(campo)?.hasError('required')){
        return `El campo es obligatorio`
      }
    }
    return;
  }

  crear(){
    this.alumnoService.guardar(this.alumnoForm.value).subscribe(() => this.router.navigate(['alumno/listar']))
  }

  private construirFormularioAlumno() {
    this.alumnoForm = new FormGroup({
      id: new FormControl(''),
      identificacion: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_IDENTIFICACION)]),
      nombre: new FormControl('', [Validators.required]),
      apellido: new FormControl('', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      correoElectronico: new FormControl('', [Validators.required]),
      tipo: new FormControl(1)
    });
  }

}
