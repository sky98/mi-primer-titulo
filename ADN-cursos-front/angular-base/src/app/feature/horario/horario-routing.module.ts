import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearHorarioComponent } from './components/crear-horario/crear-horario.component';
import { ListarHorarioComponent } from './components/listar-horario/listar-horario.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: 'crear', component: CrearHorarioComponent },
      { path: 'listar', component: ListarHorarioComponent },
      { path: '', redirectTo: 'listar' },
      { path: '**', redirectTo: 'listar' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HorarioRoutingModule { }
