import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { HttpService } from '@core/services/http.service';
import { Curso } from '@curso/shared/model/curso';
import { CursoService } from '@curso/shared/service/curso.service';
import { of } from 'rxjs/internal/observable/of';

import { ListarCursoComponent } from './listar-curso.component';

describe('ListarCursoComponent', () => {
  let component: ListarCursoComponent;
  let fixture: ComponentFixture<ListarCursoComponent>;
  let service: CursoService;

  const listaCursos = [
    new Curso(1, 'Curso 1', 'Curso 1', 'Curso 1', 2),
    new Curso(2, 'Curso 2', 'Curso 2', 'Curso 2', 1)
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarCursoComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        MatFormFieldModule,
        MatTableModule,
        MatIconModule
      ],
      providers: [ CursoService, HttpService ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarCursoComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(CursoService);
    spyOn(service, 'consultar').and.returnValue(
      of(listaCursos)
    );
    spyOn(service, 'eliminar').and.returnValue(
      of(true)
    );
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.flagCursos).toBeFalsy();
    expect(component.dataSource.length).toBe(0);
    expect(component.displayedColumns.length).toBe(4);
  });

  it('despues de ejecutar el curso service', () => {
    fixture.detectChanges();
    expect(component.dataSource.length).toBe(2);
    expect(component.flagCursos).toBeTruthy();
  });

  it('eliminar un curso', () => {
    fixture.detectChanges();
    component.eliminar(listaCursos[0]);
    expect(component.dataSource.length).toBe(1);
    expect(component.flagCursos).toBeTruthy();

    component.eliminar(listaCursos[1]);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagCursos).toBeFalsy();
  });
});
