import { NgModule } from '@angular/core';

import { SharedModule } from '@shared/shared.module';
import { MaterialModule } from '@shared/material/material.module';

import { ClaseRoutingModule } from './clase-routing.module';
import { CrearClaseComponent } from './components/crear-clase/crear-clase.component';
import { ListarClaseComponent } from './components/listar-clase/listar-clase.component';


@NgModule({
  declarations: [
    ListarClaseComponent,
    CrearClaseComponent
  ],
  imports: [
    ClaseRoutingModule,
    MaterialModule,
    SharedModule
  ]
})
export class ClaseModule { }
