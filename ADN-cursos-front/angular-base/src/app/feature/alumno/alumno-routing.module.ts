import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearAlumnoComponent } from './components/crear-alumno/crear-alumno.component';
import { ListarAlumnoComponent } from './components/listar-alumno/listar-alumno.component';

const routes: Routes = [
  { path: 'listar', component: ListarAlumnoComponent },
  { path: 'crear', component: CrearAlumnoComponent },
  { path: '', redirectTo: 'listar' },
  { path: '**', redirectTo: 'listar' }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlumnoRoutingModule { }
