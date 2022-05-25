import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearDocenteComponent } from './components/crear-docente/crear-docente.component';
import { DocenteComponent } from './components/docente/docente.component';
import { ListarDocenteComponent } from './components/listar-docente/listar-docente.component';

const routes: Routes = [
  {
    path: '',
    component: DocenteComponent,
    children: [
      {
        path: 'crear',
        component: CrearDocenteComponent
      },
      {
        path: 'listar',
        component: ListarDocenteComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocenteRoutingModule { }
