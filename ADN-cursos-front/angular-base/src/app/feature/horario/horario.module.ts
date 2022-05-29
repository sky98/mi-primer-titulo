import { NgModule } from '@angular/core';

import { CrearHorarioComponent } from './components/crear-horario/crear-horario.component';
import { HorarioRoutingModule } from './horario-routing.module';
import { HorarioService } from './shared/service/horario.service';
import { ListarHorarioComponent } from './components/listar-horario/listar-horario.component';
import { MaterialModule } from '@shared/material/material.module';
import { SharedModule } from '@shared/shared.module';


@NgModule({
  declarations: [
    CrearHorarioComponent,
    ListarHorarioComponent
  ],
  imports: [
    HorarioRoutingModule,
    MaterialModule,
    SharedModule
  ],
  providers: [HorarioService]
})
export class HorarioModule { }
