import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityGuard } from '@core/guard/security.guard';
import { HomeComponent } from '@home/home.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent, canActivate: [SecurityGuard]  },
  { path: 'producto', loadChildren: () => import('@producto/producto.module').then(mod => mod.ProductoModule) },
  { path: 'alumno', loadChildren: () => import('@alumno/alumno.module').then(mod => mod.AlumnoModule) },
  { path: 'docente', loadChildren: () => import('@docente/docente.module').then(mod => mod.DocenteModule) },
  { path: 'curso', loadChildren: () => import('@curso/curso.module').then(mod => mod.CursoModule) },
  { path: 'clase', loadChildren: () => import('@clase/clase.module').then(mod => mod.ClaseModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
