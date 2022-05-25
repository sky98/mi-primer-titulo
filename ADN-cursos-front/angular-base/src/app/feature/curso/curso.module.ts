import { NgModule } from '@angular/core';

import { CursoRoutingModule } from './curso-routing.module';
import { CrearCursoComponent } from './components/crear-curso/crear-curso.component';
import { CursoComponent } from './components/curso/curso.component';
import { ListarCursoComponent } from './components/listar-curso/listar-curso.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    CrearCursoComponent,
    CursoComponent,
    ListarCursoComponent
  ],
  imports: [
    CursoRoutingModule,
    SharedModule
  ]
})
export class CursoModule { }
