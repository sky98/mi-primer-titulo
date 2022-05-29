import { NgModule } from '@angular/core';

import { CrearDocenteComponent } from './components/crear-docente/crear-docente.component';
import { DocenteRoutingModule } from './docente-routing.module';
import { DocenteService } from './shared/service/docente.service';
import { ListarDocenteComponent } from './components/listar-docente/listar-docente.component';
import { MaterialModule } from '@shared/material/material.module';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    ListarDocenteComponent,
    CrearDocenteComponent
  ],
  imports: [
    DocenteRoutingModule,
    MaterialModule,
    SharedModule
  ],
  providers: [DocenteService]
})
export class DocenteModule { }
