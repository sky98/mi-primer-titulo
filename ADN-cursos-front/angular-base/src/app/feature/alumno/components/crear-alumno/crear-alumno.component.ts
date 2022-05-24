import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

const LONGITUD_MINIMA_IDENTIFICACION = 4;

@Component({
  selector: 'app-crear-alumno',
  templateUrl: './crear-alumno.component.html',
  styleUrls: ['./crear-alumno.component.css']
})
export class CrearAlumnoComponent implements OnInit {

  alumnoForm: FormGroup;

  constructor( protected alumnoService: AlumnoService ) { }

  ngOnInit() {
    this.construirFormularioAlumno()
  }

  crear(){
    this.alumnoService.guardar(this.alumnoForm.value).subscribe(resp => console.log(resp))
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
