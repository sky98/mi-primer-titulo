import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { of } from 'rxjs/internal/observable/of';
import { RouterTestingModule } from '@angular/router/testing';

import { CrearDocenteComponent } from './crear-docente.component';
import { DocenteService } from '@docente/shared/service/docente.service';
import { HttpService } from '@core/services/http.service';
import { Router, Routes } from '@angular/router';
import { ListarDocenteComponent } from '../listar-docente/listar-docente.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';

describe('CrearDocenteComponent', () => {
  let component: CrearDocenteComponent;
  let fixture: ComponentFixture<CrearDocenteComponent>;
  let docenteService: DocenteService;
  let router: Router;
  const routes: Routes = [
    {path: 'listar', component: ListarDocenteComponent}
  ];

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearDocenteComponent, ListarDocenteComponent ],
      imports: [
        HttpClientModule,
        RouterTestingModule.withRoutes(routes),
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule
      ],
      providers: [DocenteService, HttpService],
    })
    .compileComponents();
    router = TestBed.inject(Router);
    spyOn(router, 'navigate').and.returnValue(Promise.resolve(true));
  }));

  beforeEach(() => {
    
    fixture = TestBed.createComponent(CrearDocenteComponent);
    component = fixture.componentInstance;
    docenteService = TestBed.inject(DocenteService);
    spyOn(docenteService, 'guardar').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
    router.initialNavigation();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.docenteForm.valid).toBeFalsy();
  });

  /* it('formulario es invalido cuando número de identificación es menor de 4', () => {
    //expect(component.docenteForm.valid).toBeFalsy();
    component.docenteForm.controls.identificacion.setValue('123');
    //let error = component.validarCampo('identificacion');
    expect(component.docenteForm.controls.identificacion.errors).toThrowError('Longitud minima de 4');
  }); */

  it('Registrando docente', () => {
    expect(component.docenteForm.valid).toBeFalsy();
    component.docenteForm.controls.identificacion.setValue('1234');
    component.docenteForm.controls.nombre.setValue('test 1');
    component.docenteForm.controls.apellido.setValue('test 1');
    component.docenteForm.controls.direccion.setValue('test 1');
    component.docenteForm.controls.telefono.setValue('test 1');
    component.docenteForm.controls.correoElectronico.setValue('test 1');
    expect(component.docenteForm.valid).toBeTruthy();

    component.crear();
    
    expect(router.navigate).toHaveBeenCalledWith(['docente/listar']);
  });

});
