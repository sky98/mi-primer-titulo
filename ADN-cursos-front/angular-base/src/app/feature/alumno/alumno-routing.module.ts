import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { CrearAlumnoComponent } from './components/crear-alumno/crear-alumno.component';
import { ListarAlumnoComponent } from './components/listar-alumno/listar-alumno.component';

const routes: Routes = [
  {
    path: '',
    component: AlumnoComponent,
    children: [
      {
        path: 'crear',
        component: CrearAlumnoComponent
      },
      {
        path: 'listar',
        component: ListarAlumnoComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlumnoRoutingModule { }
