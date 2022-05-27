import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearClaseComponent } from './components/crear-clase/crear-clase.component';
import { ListarClaseComponent } from './components/listar-clase/listar-clase.component';

const routes: Routes = [
  { path: 'listar', component: ListarClaseComponent },
  { path: 'crear', component: CrearClaseComponent },
  { path: '', redirectTo: 'listar' },
  { path: '**', redirectTo: 'listar' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClaseRoutingModule { }
