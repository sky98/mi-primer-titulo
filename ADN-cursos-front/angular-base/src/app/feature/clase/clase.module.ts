import { NgModule } from '@angular/core';

import { ClaseRoutingModule } from './clase-routing.module';
import { ListarClaseComponent } from './components/listar-clase/listar-clase.component';
import { ClaseComponent } from './components/clase/clase.component';
import { CrearClaseComponent } from './components/crear-clase/crear-clase.component';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    ListarClaseComponent,
    ClaseComponent,
    CrearClaseComponent
  ],
  imports: [
    ClaseRoutingModule,
    SharedModule
  ]
})
export class ClaseModule { }
