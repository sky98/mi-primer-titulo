import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpResponse } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { AlumnoService } from './alumno.service';
import { environment } from 'src/environments/environment';
import { HttpService } from '@core/services/http.service';

describe('AlumnoService', () => {

  let httpMock: HttpTestingController;
  let alumnoService: AlumnoService;

  const apiEndpointAlumnoConsulta = `${environment.endpoint}personas/alumnos`;
  const apiEndpointAlumnos = `${environment.endpoint}personas`;

  const dummyAlumnos = [
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
      tipo              : 1
    }
  ];

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AlumnoService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    alumnoService = TestBed.inject(AlumnoService);
  });

  it('should be created', () => {
    const alumService: AlumnoService = TestBed.inject(AlumnoService);
    expect(alumService).toBeTruthy();
  });

  it('deberia listar alumnos', () => {
    alumnoService.consultar().subscribe(alumnos => {
      expect(alumnos.length).toBe(2);
      expect(alumnos).toEqual(dummyAlumnos);
    });
    const req = httpMock.expectOne(apiEndpointAlumnoConsulta);
    expect(req.request.method).toBe('GET');
    req.flush(dummyAlumnos);
  });

  it('deberia crear un alumno', () => {
    alumnoService.guardar(dummyAlumnos[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointAlumnos);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });

  it('deberia eliminar un alumno', () => {
    alumnoService.eliminar(dummyAlumnos[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpointAlumnos}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({body: true}));
  });

});
