import { Component, OnInit } from '@angular/core';

import { Clase } from '@clase/shared/model/clase';
import { ClaseService } from '@clase/shared/service/clase.service';

@Component({
  selector: 'app-listar-clase',
  templateUrl: './listar-clase.component.html',
  styleUrls: ['./listar-clase.component.css']
})
export class ListarClaseComponent implements OnInit {

  public listaClase: Clase[] = [];

  constructor(protected claseService: ClaseService) { }

  ngOnInit() {
    this.claseService.consultar().subscribe( clases =>{
      this.listaClase = clases;
      console.log(this.listaClase)
    });
  }

}
