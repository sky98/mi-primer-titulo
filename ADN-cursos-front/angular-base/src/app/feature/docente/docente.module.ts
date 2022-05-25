import { NgModule } from '@angular/core';

import { DocenteRoutingModule } from './docente-routing.module';
import { DocenteComponent } from './components/docente/docente.component';
import { ListarDocenteComponent } from './components/listar-docente/listar-docente.component';
import { CrearDocenteComponent } from './components/crear-docente/crear-docente.component';
import { DocenteService } from './shared/service/docente.service';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    DocenteComponent,
    ListarDocenteComponent,
    CrearDocenteComponent
  ],
  imports: [
    DocenteRoutingModule,
    SharedModule
  ],
  providers: [DocenteService]
})
export class DocenteModule { }
