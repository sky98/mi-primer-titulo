import { NgModule } from '@angular/core';

import { CrearSalonComponent } from './components/crear-salon/crear-salon.component';
import { ListarSalonComponent } from './components/listar-salon/listar-salon.component';
import { MaterialModule } from '@shared/material/material.module';
import { SalonRoutingModule } from './salon-routing.module';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    ListarSalonComponent,
    CrearSalonComponent
  ],
  imports: [
    MaterialModule,
    SharedModule,
    SalonRoutingModule
  ]
})
export class SalonModule { }
