import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Dias, Horario } from '../model/horario';

import { HorarioService } from './horario.service';

describe('HorarioService', () => {
  
  let httpMock: HttpTestingController;
  let service: HorarioService;

  const apiEndpoint = `${environment.endpoint}horarios`;

  const dummy = [
    new Horario('1', 1, 1, 8, 2),
    new Horario('2', 2, 2, 10, 1)
  ];

  const DIAS: Dias[] = [
    {id: 1, nombre: 'Lunes'},
    {id: 2, nombre: 'Martes'},
    {id: 3, nombre: 'Miercoles'},
    {id: 4, nombre: 'Jueves'},
    {id: 5, nombre: 'Viernes'}
  ];

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ HorarioService, HttpService ]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(HorarioService);
  });

  it('should be created', () => {
    const horarioService: HorarioService = TestBed.inject(HorarioService);
    expect(horarioService).toBeTruthy();
  });

  it('deberia listar los horarios', () => {
    service.consultar().subscribe(horarios => {
      expect(horarios.length).toBe(2);
      expect(horarios).toEqual(dummy);
    });
    const req = httpMock.expectOne(apiEndpoint);
    expect(req.request.method).toBe('GET');
    req.flush(dummy);
  });

  it('deberia crear un horario', () => {
    service.guardar(dummy[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpoint);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });

  it('deberia eliminar un horario', () => {
    service.eliminar(dummy[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpoint}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({body: true}));
  });

  it('deberia listar los días', () => {
    expect(service.getDias()).toEqual(DIAS );
  });

  it('deberia devolver un día', () => {
    expect(service.getDia(DIAS[0].id)).toBe(DIAS[0].nombre);
  });
});
