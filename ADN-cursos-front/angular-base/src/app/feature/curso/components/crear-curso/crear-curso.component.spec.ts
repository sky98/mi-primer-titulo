import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { Router, Routes } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from '@core/services/http.service';
import { CursoService } from '@curso/shared/service/curso.service';
import { of } from 'rxjs/internal/observable/of';
import { ListarCursoComponent } from '../listar-curso/listar-curso.component';

import { CrearCursoComponent } from './crear-curso.component';

describe('CrearCursoComponent', () => {
  let component: CrearCursoComponent;
  let fixture: ComponentFixture<CrearCursoComponent>;
  let service : CursoService;
  let router: Router;
  let routes: Routes = [
    {path: 'listar', component: ListarCursoComponent}
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearCursoComponent, ListarCursoComponent ],
      imports: [
        HttpClientModule,
        RouterTestingModule.withRoutes(routes),
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule,
        MatTableModule,
        MatIconModule
      ],
      providers: [CursoService, HttpService],
    })
    .compileComponents();
    router = TestBed.inject(Router);
    spyOn(router, 'navigate').and.returnValue(Promise.resolve(true));
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearCursoComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(CursoService);
    spyOn(service, 'guardar').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
    router.initialNavigation();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.cursoForm.valid).toBeFalsy();
  });

  it('formulario es invalido', () => {
    component.cursoForm.controls.horas.setValue(6);
    component.cursoForm.markAsTouched();
    expect(component.validarCampo('horas')).toEqual('Debe ingresar un valor mayor a 1 y menor a 5');
    component.cursoForm.controls.horas.setValue(null);
    component.cursoForm.markAsTouched();
    expect(component.validarCampo('horas')).toEqual('El campo es obligatorio');
  });

  it('Registrando curso', () => {
    expect(component.cursoForm.valid).toBeFalsy();
    component.cursoForm.controls.nombre.setValue('test 1');
    component.cursoForm.controls.descripcion.setValue('test 1');
    component.cursoForm.controls.horas.setValue(2);
    expect(component.cursoForm.valid).toBeTruthy();

    component.crear();
    
    expect(router.navigate).toHaveBeenCalledWith(['curso/listar']);
  });

});
