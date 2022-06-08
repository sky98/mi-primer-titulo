import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { of } from 'rxjs/internal/observable/of';
import { Router, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { CrearAlumnoComponent } from './crear-alumno.component';
import { HttpService } from '@core/services/http.service';
import { ListarAlumnoComponent } from '../listar-alumno/listar-alumno.component';

import { MatSnackBarModule } from '@angular/material/snack-bar';


describe('CrearAlumnoComponent', () => {
  let component: CrearAlumnoComponent;
  let fixture: ComponentFixture<CrearAlumnoComponent>;
  let alumnoService: AlumnoService;
  let router: Router;
  const routes: Routes = [
    {path: 'listar', component: ListarAlumnoComponent}
  ];

  beforeEach(async () => {
    TestBed.configureTestingModule({
      declarations: [ CrearAlumnoComponent, ListarAlumnoComponent ],
      imports: [
        HttpClientModule,
        RouterTestingModule.withRoutes(routes),
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule
      ],
      providers: [AlumnoService, HttpService],
    })
    .compileComponents();
    router = TestBed.inject(Router);
    spyOn(router, 'navigate').and.returnValue(Promise.resolve(true));
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearAlumnoComponent);
    component = fixture.componentInstance;
    alumnoService = TestBed.inject(AlumnoService);
    spyOn(alumnoService, 'guardar').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
    router.initialNavigation();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.alumnoForm.valid).toBeFalsy();
  });

  it('Registrando alumno', () => {
    expect(component.alumnoForm.valid).toBeFalsy();
    component.alumnoForm.controls.identificacion.setValue('1234');
    component.alumnoForm.controls.nombre.setValue('test 1');
    component.alumnoForm.controls.apellido.setValue('test 1');
    component.alumnoForm.controls.direccion.setValue('test 1');
    component.alumnoForm.controls.telefono.setValue('test 1');
    component.alumnoForm.controls.correoElectronico.setValue('test 1');
    expect(component.alumnoForm.valid).toBeTruthy();

    component.crear();
    
    expect(router.navigate).toHaveBeenCalledWith(['alumno/listar']);
  });
});