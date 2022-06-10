import { Alumno } from '@alumno/shared/model/alumno';
import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpService } from '@core/services/http.service';
import { SalonService } from '@salon/shared/service/salon.service';
import { of } from 'rxjs/internal/observable/of';

import { CrearSalonComponent } from './crear-salon.component';

describe('CrearSalonComponent', () => {
  let component: CrearSalonComponent;
  let fixture: ComponentFixture<CrearSalonComponent>;

  let service: SalonService;
  let alumnoService: AlumnoService;

  const listaAlumnos = [
    new Alumno(1, 'Alumno 1', 'Alumno 1', 'Alumno 1', 'Alumno 1', 'Alumno 1', 'Alumno 1'),
    new Alumno(2, 'Alumno 2', 'Alumno 2', 'Alumno 2', 'Alumno 2', 'Alumno 2', 'Alumno 2')
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearSalonComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule
      ],
      providers: [ AlumnoService, SalonService, HttpService],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearSalonComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(SalonService);
    alumnoService = TestBed.inject(AlumnoService);
    spyOn(service, 'guardar').and.returnValue(
      of(true)
    );
    
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.salonForm.valid).toBeFalsy();
    expect(component.flagAlumno).toBeFalsy();
    expect(component.flagCurso).toBeFalsy();
    expect(component.listaAlumnos.length).toBe(0);
    expect(component.listaCursos.length).toBe(0);
  });

  it('####', () => {
    spyOn(alumnoService, 'consultar').and.returnValue(
      of(listaAlumnos)
    );
  });

  it('formulario es invalido', () => {
    component.salonForm.controls.alumno.setValue(null);
    component.salonForm.markAsTouched();
    expect(component.validarCampo('alumno')).toEqual('El campo es obligatorio');
  });

  it('Registrando salones', () => {
    expect(component.salonForm.valid).toBeFalsy();
    component.salonForm.controls.alumno.setValue(1);
    component.salonForm.controls.curso.setValue(2);
    expect(component.salonForm.valid).toBeTruthy();
  });

});
