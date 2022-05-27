import { Component, OnInit } from '@angular/core';

import { Clase } from '@clase/shared/model/clase';
import { ClaseService } from '@clase/shared/service/clase.service';

@Component({
  selector: 'app-listar-clase',
  templateUrl: './listar-clase.component.html',
  styleUrls: ['./listar-clase.component.css']
})
export class ListarClaseComponent implements OnInit {

  dataSource: Clase[] = [];
  flagClases: boolean = false;
  displayedColumns = ['nombre_docente', 'nombre_curso', 'accion'];

  constructor(protected claseService: ClaseService) { }

  ngOnInit() {
    this.claseService.consultar().subscribe( clases =>{
      if(clases.length>0){
        this.dataSource = clases;
        this.flagClases = true;
      }
    });
  }

  eliminar(clase: Clase){
    this.claseService.eliminar(clase).subscribe( ()=> {
      this.dataSource = this.dataSource.filter(x => x.id!=clase.id);
      (this.dataSource.length<1)?this.flagClases=false:this.flagClases=true;
    });
  }

}
