import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ClaseService } from '@clase/shared/service/clase.service';

@Component({
  selector: 'app-crear-clase',
  templateUrl: './crear-clase.component.html',
  styleUrls: ['./crear-clase.component.css']
})
export class CrearClaseComponent implements OnInit {

  claseForm: FormGroup;

  constructor(protected claseService: ClaseService, protected router: Router) { }

  ngOnInit() {
    this.construirFormularioClase();
  }

  crear(){
    this.claseService.guardar(this.claseForm.value).subscribe(() => this.router.navigate(['clase/listar']))
  }

  private construirFormularioClase() {
    this.claseForm = new FormGroup({
      id: new FormControl(''),
      curso: new FormControl('', [Validators.required]),
      docente: new FormControl('', [Validators.required])
    });
  }

}
