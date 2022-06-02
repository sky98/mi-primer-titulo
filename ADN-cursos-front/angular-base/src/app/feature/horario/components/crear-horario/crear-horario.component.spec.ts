import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { Router, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { HorarioService } from '@horario/shared/service/horario.service';
import { of } from 'rxjs/internal/observable/of';
import { ListarHorarioComponent } from '../listar-horario/listar-horario.component';

import { CrearHorarioComponent } from './crear-horario.component';

describe('CrearHorarioComponent', () => {
  let component: CrearHorarioComponent;
  let fixture: ComponentFixture<CrearHorarioComponent>;
  let service: HorarioService;
  let router: Router;
  const routes: Routes = [
    {path: 'listar', component: ListarHorarioComponent}
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearHorarioComponent ],
      imports: [
        HttpClientModule,
        RouterTestingModule.withRoutes(routes),
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule
      ],
      providers: [ HorarioService, HttpService],
    })
    .compileComponents();
    router = TestBed.inject(Router);
    spyOn(router, 'navigate').and.returnValue(Promise.resolve(true));
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearHorarioComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(HorarioService);
    spyOn(service, 'guardar').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
    router.initialNavigation();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.dias.length).toHaveSize(0);
    expect(component.horas.length).toBe(8);
    expect(component.cantidadHoras.length).toBe(4);
    expect(component.controlHoras.length).toBe(4);
    expect(component.horarioForm.valid).toBeFalsy();
    expect(component.listaClases.length).toBe(0);
    expect(component.flagClases).toBeFalsy();
  });

  it('Registrando horario', () => {
    expect(component.horarioForm.valid).toBeFalsy();
    component.horarioForm.controls.clase.setValue(1);
    component.horarioForm.controls.dia.setValue(1);
    component.horarioForm.controls.horaInicio.setValue(8);
    component.horarioForm.controls.cantidadHoras.setValue(2);
    expect(component.horarioForm.valid).toBeTruthy();

    component.crear();
    
    expect(router.navigate).toHaveBeenCalledWith(['horario/listar']);
  });
});
