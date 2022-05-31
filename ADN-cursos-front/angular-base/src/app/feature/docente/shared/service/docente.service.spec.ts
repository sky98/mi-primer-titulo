import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { DocenteService } from './docente.service';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';
import { HttpResponse } from '@angular/common/http';

describe('DocenteService', () => {

  let httpMock: HttpTestingController;
  let docenteService: DocenteService;

  const apiEndpointDocenteConsulta = `${environment.endpoint}personas/docentes`;
  const apiEndpointDocentes = `${environment.endpoint}personas`;

  const dummyDocentes  = [
    {
      id                : 1, 
      identificacion    : 'test1', 
      nombre            : 'test1', 
      apellido          : 'test1', 
      direccion         : 'test1', 
      telefono          : 'test1', 
      correoElectronico : 'test1', 
      tipo              : 1
    },
    {
      id                : 2, 
      identificacion    : 'test2', 
      nombre            : 'test2', 
      apellido          : 'test2', 
      direccion         : 'test2', 
      telefono          : 'test2', 
      correoElectronico : 'test2', 
      tipo              : 2
    }
  ]; 

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [DocenteService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    docenteService = TestBed.inject(DocenteService);
  });

  it('should be created', () => {
    const docentService: DocenteService = TestBed.inject(DocenteService);
    expect(docentService).toBeTruthy();
  });

  it('deberia listar docentes', () => {
    docenteService.consultar().subscribe(docentes => {
      expect(docentes.length).toBe(2);
      expect(docentes).toEqual(dummyDocentes);
    });
    const req = httpMock.expectOne(apiEndpointDocenteConsulta);
    expect(req.request.method).toBe('GET');
    req.flush(dummyDocentes);
  });

  it('deberia obtener un docente segun su id', () => {
    docenteService.obtenerDocente(dummyDocentes[0].id).subscribe(docente => {
      expect(docente).toEqual(dummyDocentes[0]);
    });
    const req = httpMock.expectOne(`${apiEndpointDocenteConsulta}/1`);
    expect(req.request.method).toBe('GET');
    req.flush(dummyDocentes[0]);
  });

  it('deberia crear un docente', () => {
    docenteService.guardar(dummyDocentes[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointDocentes);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });

  it('deberia eliminar un docente', () => {
    docenteService.eliminar(dummyDocentes[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpointDocentes}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({body: true}));
  });

});
