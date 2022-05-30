import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearSalonComponent } from './components/crear-salon/crear-salon.component';
import { ListarSalonComponent } from './components/listar-salon/listar-salon.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: 'crear', component: CrearSalonComponent },
      { path: 'listar', component: ListarSalonComponent },
      { path: '', redirectTo: 'crear' },
      { path: '**', redirectTo: 'crear' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalonRoutingModule { }
