import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//import { RouterTestingModule } from '@angular/router/testing';

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
    new Docente(1, '1234', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1', 2),
    new Docente(2, '12345', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1', 2),
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarDocenteComponent ],
      imports: [
        HttpClientModule,
        //RouterTestingModule.withRoutes(routes),
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
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
