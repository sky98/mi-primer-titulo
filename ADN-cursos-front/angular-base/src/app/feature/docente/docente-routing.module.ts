import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearDocenteComponent } from './components/crear-docente/crear-docente.component';
import { ListarDocenteComponent } from './components/listar-docente/listar-docente.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: 'crear', component: CrearDocenteComponent },
      { path: 'listar', component: ListarDocenteComponent },
      { path: '', redirectTo: 'listar' },
      { path: '**', redirectTo: 'listar' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocenteRoutingModule { }
