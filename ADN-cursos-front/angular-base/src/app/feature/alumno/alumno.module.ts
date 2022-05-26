import { NgModule } from '@angular/core';

import { SharedModule } from '@shared/shared.module';
import { MaterialModule } from '@shared/material/material.module';

import { AlumnoRoutingModule } from './alumno-routing.module';
import { CrearAlumnoComponent } from './components/crear-alumno/crear-alumno.component';
import { ListarAlumnoComponent } from './components/listar-alumno/listar-alumno.component';
import { AlumnoService } from './shared/service/alumno.service';

@NgModule({
  declarations: [
    CrearAlumnoComponent,
    ListarAlumnoComponent
  ],
  imports: [
    AlumnoRoutingModule,
    MaterialModule,
    SharedModule
  ],
  providers: [AlumnoService]
})
export class AlumnoModule { }
