import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: '', redirectTo: '/alumno/listar', pathMatch: 'full' },
  { path: 'alumno', loadChildren: () => import('@alumno/alumno.module').then(mod => mod.AlumnoModule) },
  { path: 'docente', loadChildren: () => import('@docente/docente.module').then(mod => mod.DocenteModule) },
  { path: 'curso', loadChildren: () => import('@curso/curso.module').then(mod => mod.CursoModule) },
  { path: 'clase', loadChildren: () => import('@clase/clase.module').then(mod => mod.ClaseModule) },
  { path: 'horario', loadChildren: () => import('@horario/horario.module').then(mod => mod.HorarioModule) },
  { path: 'salon', loadChildren: () => import('@salon/salon.module').then(mod => mod.SalonModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
