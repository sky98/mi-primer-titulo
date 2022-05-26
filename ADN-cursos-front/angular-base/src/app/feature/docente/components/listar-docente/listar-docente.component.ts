import { Component, OnInit } from '@angular/core';

import { Docente } from '@docente/shared/model/docente';
import { DocenteService } from '@docente/shared/service/docente.service';

@Component({
  selector: 'app-listar-docente',
  templateUrl: './listar-docente.component.html',
  styleUrls: ['./listar-docente.component.css']
})
export class ListarDocenteComponent implements OnInit {

  flagDocentes: boolean = false;

  dataSource: Docente[] = [];
  displayedColumns = ['identificacion', 'nombres', 'direccion', 'telefono', 'accion'];

  constructor(protected docenteService: DocenteService) { }

  ngOnInit() {
    this.docenteService.consultar().subscribe(docentes =>{ 
      if(docentes.length > 0){
        this.dataSource = docentes;
        this.flagDocentes = true;
      }
    });
  }

  eliminar(docente: Docente){
    this.docenteService.eliminar(docente).subscribe( ()=>{
      this.dataSource = this.dataSource.filter(x => x.id!=docente.id);
      (this.dataSource.length<1)?this.flagDocentes=false:this.flagDocentes=true;
    });
  }

}
