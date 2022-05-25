import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DocenteService } from '@docente/shared/service/docente.service';

const LONGITUD_MINIMA_IDENTIFICACION = 4;

@Component({
  selector: 'app-crear-docente',
  templateUrl: './crear-docente.component.html',
  styleUrls: ['./crear-docente.component.css']
})
export class CrearDocenteComponent implements OnInit {

  docenteForm: FormGroup;

  constructor(protected docenteService: DocenteService, protected router: Router) { }

  ngOnInit() {
    this.construirFormularioDocente();
  }

  crear(){
    this.docenteService.guardar(this.docenteForm.value).subscribe(() => this.router.navigate(['docente/listar']))
  }

  private construirFormularioDocente() {
    this.docenteForm = new FormGroup({
      id: new FormControl(''),
      identificacion: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_IDENTIFICACION)]),
      nombre: new FormControl('', [Validators.required]),
      apellido: new FormControl('', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      correoElectronico: new FormControl('', [Validators.required]),
      tipo: new FormControl(2)
    });
  }

}
