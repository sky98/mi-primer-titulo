import { Alumno } from '@alumno/shared/model/alumno';
import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { HttpService } from '@core/services/http.service';
import { Curso } from '@curso/shared/model/curso';
import { CursoService } from '@curso/shared/service/curso.service';
import { SalonService } from '@salon/shared/service/salon.service';
import { of } from 'rxjs/internal/observable/of';

import { CrearSalonComponent } from './crear-salon.component';

describe('CrearSalonComponent', () => {
  let component: CrearSalonComponent;
  let fixture: ComponentFixture<CrearSalonComponent>;

  let service: SalonService;
  let alumnoService: AlumnoService;
  let cursoService: CursoService;

  const listaAlumnos = [
    new Alumno(1, 'Alumno 1', 'Alumno 1', 'Alumno 1', 'Alumno 1', 'Alumno 1', 'Alumno 1'),
    new Alumno(2, 'Alumno 2', 'Alumno 2', 'Alumno 2', 'Alumno 2', 'Alumno 2', 'Alumno 2')
  ];

  const listaCursos = [
    new Curso(1, 'Curso 1', 'Curso 1', 'Curso 1', 2),
    new Curso(2, 'Curso 2', 'Curso 2', 'Curso 2', 3)
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearSalonComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule,
        MatFormFieldModule,
        MatTableModule,
        MatIconModule
      ],
      providers: [ AlumnoService, CursoService, SalonService, HttpService],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearSalonComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(SalonService);
    alumnoService = TestBed.inject(AlumnoService);
    cursoService = TestBed.inject(CursoService);
    spyOn(service, 'guardar').and.returnValue(
      of(true)
    );   
    spyOn(alumnoService, 'consultar').and.returnValue(
      of(listaAlumnos)
    ); 
    spyOn(cursoService, 'consultar').and.returnValue(
      of(listaCursos)
    ); 
    //fixture.detectChanges();
  });

  it('should create',async () => {
    await expect(component).toBeTruthy();
    await expect(component.salonForm).toBeFalsy();
    await expect(component.flagAlumno).toBeFalsy();
    await expect(component.flagCurso).toBeFalsy();
    await expect(component.listaAlumnos.length).toBe(0);
    await expect(component.listaCursos.length).toBe(0);
  });

  it('formulario es invalido',async () => {
    await component.ngOnInit();
    await component.salonForm.controls.alumno.setValue(null);
    await component.salonForm.markAsTouched();
    await expect(component.validarCampo('alumno')).toEqual('El campo es obligatorio');
  });

  it('Registrando salones',async () => {
    await component.ngOnInit();
    await expect(component.salonForm.valid).toBeFalsy();
    await component.salonForm.controls.alumno.setValue(1);
    await component.salonForm.controls.curso.setValue(2);
    await expect(component.salonForm.valid).toBeTruthy();
  });

});
