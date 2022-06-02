import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
});
