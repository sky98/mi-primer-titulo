import { environment } from 'src/environments/environment';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';

import { CursoService } from './curso.service';
import { Curso } from '../model/curso';
import { HttpService } from '@core/services/http.service';
import { HttpResponse } from '@angular/common/http';

describe('CursoService', () => {

  let httpMock: HttpTestingController;
  let service: CursoService;

  const apiEndpointCursos = `${environment.endpoint}cursos`;

  const dummyCursos = [
    new Curso(1, 'Curso 1', 'Curso 1', 'Curso 1', 2),
    new Curso(2, 'Curso 2', 'Curso 2', 'Curso 2', 1)
  ];

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CursoService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(CursoService);
  });

  it('should be created', () => {
    const cursoService: CursoService = TestBed.inject(CursoService);
    expect(cursoService).toBeTruthy();
  });

  it('deberia listar los cursos', () => {
    service.consultar().subscribe(cursos => {
      expect(cursos.length).toBe(2);
      expect(cursos).toEqual(dummyCursos);
    });
    const req = httpMock.expectOne(apiEndpointCursos);
    expect(req.request.method).toBe('GET');
    req.flush(dummyCursos);
  });

  it('deberia obtener un curso segun su id', () => {
    service.obtenerCurso(dummyCursos[0].id).subscribe(curso => {
      expect(curso).toEqual(dummyCursos[0]);
    });
    const req = httpMock.expectOne(`${apiEndpointCursos}/1`);
    expect(req.request.method).toBe('GET');
    req.flush(dummyCursos[0]);
  });

  it('deberia crear un curso', () => {
    service.guardar(dummyCursos[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointCursos);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });

  it('deberia eliminar un curso', () => {
    service.eliminar(dummyCursos[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpointCursos}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({body: true}));
  });

});
