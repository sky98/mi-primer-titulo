import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Docente } from '@docente/shared/model/docente';
import { DocenteService } from '@docente/shared/service/docente.service';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs/internal/observable/of';

import { ListarDocenteComponent } from './listar-docente.component';

describe('ListarDocenteComponent', () => {
  let component: ListarDocenteComponent;
  let fixture: ComponentFixture<ListarDocenteComponent>;
  let docenteService: DocenteService;

  const listDocente: Docente[] = [
    new Docente(1, '1234', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1'),
    new Docente(2, '12345', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1'),
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarDocenteComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
      ],
      providers: [DocenteService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarDocenteComponent);
    component = fixture.componentInstance;
    docenteService = TestBed.inject(DocenteService);
    spyOn(docenteService, 'consultar').and.returnValue(
      of(listDocente)
    );
    spyOn(docenteService, 'eliminar').and.returnValue(
      of(true)
    );
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.displayedColumns.length).toBe(5);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagDocentes).toBeFalsy();
  });

  it('despues de ejecutar el docente service', () => {
    fixture.detectChanges();
    expect(component.dataSource.length).toBe(2);
    expect(component.flagDocentes).toBeTruthy();
  });

  it('eliminar un docente', () => {
    fixture.detectChanges();
    component.eliminar(listDocente[0]);
    expect(component.dataSource.length).toBe(1);
    expect(component.flagDocentes).toBeTruthy();

    component.eliminar(listDocente[1]);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagDocentes).toBeFalsy();
  });

});
