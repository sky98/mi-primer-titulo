import { Component } from '@angular/core';
import { MenuItem } from '@core/modelo/menu-item';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-base';
  public companies: MenuItem[] = [
    { url: '/alumno', nombre: 'alumno' },
    { url: '/docente', nombre: 'docente' },
    { url: '/curso', nombre: 'curso' },    
    { url: '/clase', nombre: 'clase' },    
    { url: '/horario', nombre: 'horario' },    
    { url: '/salon', nombre: 'salon' }    
  ];

  
}
