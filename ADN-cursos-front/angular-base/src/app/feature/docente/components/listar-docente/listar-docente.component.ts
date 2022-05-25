import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Docente } from '@docente/shared/model/docente';
import { DocenteService } from '@docente/shared/service/docente.service';

@Component({
  selector: 'app-listar-docente',
  templateUrl: './listar-docente.component.html',
  styleUrls: ['./listar-docente.component.css']
})
export class ListarDocenteComponent implements OnInit {

  public listaDocentes: Observable<Docente[]>;

  constructor(protected docenteService: DocenteService) { }

  ngOnInit() {
    this.listaDocentes = this.docenteService.consultar();
  }

  eliminar(docente: Docente){
    this.docenteService.eliminar(docente).subscribe();
  }

}
