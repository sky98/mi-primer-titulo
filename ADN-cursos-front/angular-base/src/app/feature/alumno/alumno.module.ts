import { NgModule } from '@angular/core';

import { AlumnoRoutingModule } from './alumno-routing.module';
import { CrearAlumnoComponent } from './components/crear-alumno/crear-alumno.component';
import { ListarAlumnoComponent } from './components/listar-alumno/listar-alumno.component';
import { BorrarAlumnoComponent } from './components/borrar-alumno/borrar-alumno.component';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { SharedModule } from '@shared/shared.module';
import { AlumnoService } from './shared/service/alumno.service';


@NgModule({
  declarations: [
    CrearAlumnoComponent,
    ListarAlumnoComponent,
    BorrarAlumnoComponent,
    AlumnoComponent
  ],
  imports: [
    AlumnoRoutingModule,
    SharedModule
  ],
  providers: [AlumnoService]
})
export class AlumnoModule { }
