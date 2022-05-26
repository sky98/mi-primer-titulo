import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

  listaCursos: Curso[];
  listaDocentes: Docente[];

  flagDocente: boolean = false;
  flagCurso: boolean = false;

  constructor(protected claseService: ClaseService, protected cursoServie:CursoService, 
              protected docenteService: DocenteService, protected router: Router) { }

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
