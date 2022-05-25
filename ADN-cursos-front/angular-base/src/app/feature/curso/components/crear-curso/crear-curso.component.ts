import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CursoService } from '@curso/shared/service/curso.service';

const LONGITUD_ADMITIDAS_HORAS = '([1-4])';

@Component({
  selector: 'app-crear-curso',
  templateUrl: './crear-curso.component.html',
  styleUrls: ['./crear-curso.component.css']
})
export class CrearCursoComponent implements OnInit {

  cursoForm: FormGroup;

  constructor(protected cursoService: CursoService, protected router: Router) { }

  ngOnInit(): void {
    this.construirFormularioCurso();
  }

  crear(){
    this.cursoService.guardar(this.cursoForm.value).subscribe(() => this.router.navigate(['curso/listar']))
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

}
