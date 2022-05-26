import { NgModule } from '@angular/core';

import { DocenteRoutingModule } from './docente-routing.module';
import { ListarDocenteComponent } from './components/listar-docente/listar-docente.component';
import { CrearDocenteComponent } from './components/crear-docente/crear-docente.component';
import { DocenteService } from './shared/service/docente.service';
import { SharedModule } from '@shared/shared.module';
import { MaterialModule } from '@shared/material/material.module';


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
