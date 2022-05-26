import { NgModule } from '@angular/core';

import { CursoRoutingModule } from './curso-routing.module';
import { CrearCursoComponent } from './components/crear-curso/crear-curso.component';
import { ListarCursoComponent } from './components/listar-curso/listar-curso.component';
import { SharedModule } from '@shared/shared.module';
import { MaterialModule } from '@shared/material/material.module';


@NgModule({
  declarations: [
    CrearCursoComponent,
    ListarCursoComponent
  ],
  imports: [
    CursoRoutingModule,
    MaterialModule,
    SharedModule
  ]
})
export class CursoModule { }
