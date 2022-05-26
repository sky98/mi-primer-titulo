import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CrearCursoComponent } from './components/crear-curso/crear-curso.component';
import { ListarCursoComponent } from './components/listar-curso/listar-curso.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: 'crear', component: CrearCursoComponent },
      { path: 'listar', component: ListarCursoComponent },
      { path: '', redirectTo: 'listar' },
      { path: '**', redirectTo: 'listar' },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CursoRoutingModule { }
