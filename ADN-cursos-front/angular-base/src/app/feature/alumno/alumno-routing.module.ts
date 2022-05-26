import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearAlumnoComponent } from './components/crear-alumno/crear-alumno.component';
import { ListarAlumnoComponent } from './components/listar-alumno/listar-alumno.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: 'crear', component: CrearAlumnoComponent },
      { path: 'listar', component: ListarAlumnoComponent },
      { path: '', redirectTo: 'listar' },
      { path: '**', redirectTo: 'listar' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlumnoRoutingModule { }
