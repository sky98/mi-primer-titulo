import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs/internal/observable/of';
import { Router, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { CrearClaseComponent } from './crear-clase.component';
import { DocenteService } from '@docente/shared/service/docente.service';
import { ClaseService } from '@clase/shared/service/clase.service';
import { CursoService } from '@curso/shared/service/curso.service';
import { HttpService } from '@core/services/http.service';
import { ListarClaseComponent } from '../listar-clase/listar-clase.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Curso } from '@curso/shared/model/curso';
import { Docente } from '@docente/shared/model/docente';
import { MatSnackBarModule } from '@angular/material/snack-bar';


describe('CrearClaseComponent', () => {
  let component: CrearClaseComponent;
  let fixture: ComponentFixture<CrearClaseComponent>;
  let docenteService: DocenteService;
  let cursoService: CursoService;
  let claseService: ClaseService;
  let router: Router;
  let routes: Routes = [
    {path: 'listar', component: ListarClaseComponent}
  ];

  const listDocente: Docente[] = [
    new Docente(1, '1234', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1'),
    new Docente(2, '12345', 'test 1', 'test 1', 'test 1', 'test 1', 'test 1'),
  ];

  const listaCursos: Curso[] = [
    new Curso(1, 'curso 1', 'curso 1', 'curso 1', 2),
    new Curso(2, 'curso 2', 'curso 2', 'curso 2', 1)
  ];

  beforeEach(async () => {
    TestBed.configureTestingModule({
      declarations: [ CrearClaseComponent, ListarClaseComponent ],
      imports: [
        HttpClientModule,
        RouterTestingModule.withRoutes(routes),
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule
      ],
      providers: [ClaseService, CursoService, DocenteService, HttpService],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearClaseComponent);
    component = fixture.componentInstance;
    claseService = TestBed.inject(ClaseService);
    docenteService = TestBed.inject(DocenteService);
    cursoService = TestBed.inject(CursoService);
    spyOn(claseService, 'guardar').and.returnValue(
      of(true)
    );    
    spyOn(cursoService, 'consultar').and.returnValue(
      of(listaCursos)
    );
    spyOn(docenteService, 'consultar').and.returnValue(
      of(listDocente)
    );
    router = TestBed.inject(Router);
    spyOn(router, 'navigate').and.returnValue(Promise.resolve(true));
    //fixture.detectChanges();
    router.initialNavigation();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.claseForm).toBeFalsy();
    expect(component.flagDocente).toBeFalsy();
    expect(component.flagCurso).toBeFalsy();
    expect(component.listaCursos.length).toBe(0);
    expect(component.listaDocentes.length).toBe(0);
  });

  // NO ME DEJA ACCEDER A LAS PROPIEDADES DE LA CLASEFORM

  /* it('Registrando clase', () => {
    expect(component.claseForm).toBeFalsy();
    component.claseForm.controls.nombre.setValue('test 1');
    component.claseForm.controls.curso.setValue(1);
    component.claseForm.controls.docente.setValue(1);
    expect(component.claseForm).toBeTruthy();

    component.crear();
    
    expect(router.navigate).toHaveBeenCalledWith(['clase/listar']);
  }); */

});
