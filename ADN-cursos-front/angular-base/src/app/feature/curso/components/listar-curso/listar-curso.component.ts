import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Curso } from '@curso/shared/model/curso';
import { CursoService } from '@curso/shared/service/curso.service';

@Component({
  selector: 'app-listar-curso',
  templateUrl: './listar-curso.component.html',
  styleUrls: ['./listar-curso.component.css']
})
export class ListarCursoComponent implements OnInit {

  public listaCursos: Observable<Curso[]>;

  constructor(protected cursoService: CursoService) { }

  ngOnInit() {
    this.listaCursos = this.cursoService.consultar();
  }

  eliminar(curso: Curso){
    this.cursoService.eliminar(curso).subscribe();
  }

}
