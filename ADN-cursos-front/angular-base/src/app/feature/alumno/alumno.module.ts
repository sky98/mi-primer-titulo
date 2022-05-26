import { NgModule } from '@angular/core';

import { AlumnoRoutingModule } from './alumno-routing.module';
import { CrearAlumnoComponent } from './components/crear-alumno/crear-alumno.component';
import { ListarAlumnoComponent } from './components/listar-alumno/listar-alumno.component';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { SharedModule } from '@shared/shared.module';
import { AlumnoService } from './shared/service/alumno.service';
import { MaterialModule } from '@shared/material/material.module';


@NgModule({
  declarations: [
    CrearAlumnoComponent,
    ListarAlumnoComponent,
    AlumnoComponent
  ],
  imports: [
    AlumnoRoutingModule,
    MaterialModule,
    SharedModule
  ],
  providers: [AlumnoService]
})
export class AlumnoModule { }
