import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Clase } from '../model/clase';

import { ClaseService } from './clase.service';

describe('ClaseService', () => {

  let httpMock: HttpTestingController;
  let claseService: ClaseService;

  const apiEndpointClase = `${environment.endpoint}clases`;

  const dummyClases = [
    new Clase(1, 'clase 1', 1, 1),
    new Clase(2, 'clase 2', 1, 1)
  ];

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ClaseService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    claseService = TestBed.inject(ClaseService);
  });

  it('should be created', () => {
    const clasService: ClaseService = TestBed.inject(ClaseService);
    expect(clasService).toBeTruthy();
  });

  it('deberia listar las clases', () => {
    claseService.consultar().subscribe(clases => {
      expect(clases.length).toBe(2);
      expect(clases).toEqual(dummyClases);
    });
    const req = httpMock.expectOne(apiEndpointClase);
    expect(req.request.method).toBe('GET');
    req.flush(dummyClases);
  });

  it('deberia crear una clase', () => {
    claseService.guardar(dummyClases[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointClase);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });

  it('deberia eliminar una clase', () => {
    claseService.eliminar(dummyClases[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(`${apiEndpointClase}/1`);
    expect(req.request.method).toBe('DELETE');
    req.event(new HttpResponse<boolean>({body: true}));
  });
});
