import { Component, OnInit } from '@angular/core';

import { Curso } from '@curso/shared/model/curso';
import { CursoService } from '@curso/shared/service/curso.service';

@Component({
  selector: 'app-listar-curso',
  templateUrl: './listar-curso.component.html',
  styleUrls: ['./listar-curso.component.css']
})
export class ListarCursoComponent implements OnInit {

  flagCursos: boolean = false;  
  dataSource: Curso[] = [];
  displayedColumns = ['nombre', 'descripcion', 'horas', 'accion'];
  
  constructor(protected cursoService: CursoService) { }

  ngOnInit() {
    this.cursoService.consultar().subscribe(cursos =>{
      if(cursos.length>0){
        this.dataSource = cursos;
        this.flagCursos = true;
      }
    });
  }

  eliminar(curso: Curso){
    this.cursoService.eliminar(curso).subscribe( ()=>{
      this.dataSource = this.dataSource.filter(x => x.id!=curso.id);
      (this.dataSource.length<1)?this.flagCursos=false:this.flagCursos=true;
    });
  }

}
