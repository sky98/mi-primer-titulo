import { Alumno } from '@alumno/shared/model/alumno';
import { AlumnoService } from '@alumno/shared/service/alumno.service';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs/internal/observable/of';

import { ListarAlumnoComponent } from './listar-alumno.component';

describe('ListarAlumnoComponent', () => {
  let component: ListarAlumnoComponent;
  let fixture: ComponentFixture<ListarAlumnoComponent>;
  let alumnoService: AlumnoService;

  const listAlumnos: Alumno[] = [
    new Alumno(1, '1234', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1'),
    new Alumno(2, '12345', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1'),
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarAlumnoComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        MatFormFieldModule,
        MatTableModule,
        MatIconModule
      ],
      providers: [AlumnoService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarAlumnoComponent);
    component = fixture.componentInstance;
    alumnoService = TestBed.inject(AlumnoService);
    spyOn(alumnoService, 'consultar').and.returnValue(
      of(listAlumnos)
    );
    spyOn(alumnoService, 'eliminar').and.returnValue(
      of(true)
    );
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.displayedColumns.length).toBe(5);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagAlumnos).toBeFalsy();
  });

  it('despues de ejecutar el alumno service', () => {
    fixture.detectChanges();
    expect(component.dataSource.length).toBe(2);
    expect(component.flagAlumnos).toBeTruthy();
  });

  it('eliminar un alumno', () => {
    fixture.detectChanges();
    component.eliminar(listAlumnos[0]);
    expect(component.dataSource.length).toBe(1);
    expect(component.flagAlumnos).toBeTruthy();

    component.eliminar(listAlumnos[1]);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagAlumnos).toBeFalsy();
  });
});
