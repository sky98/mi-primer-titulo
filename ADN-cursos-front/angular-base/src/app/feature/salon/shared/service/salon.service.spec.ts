import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from '@core/services/http.service';
import { environment } from 'src/environments/environment';
import { Salon } from '../model/salon';

import { SalonService } from './salon.service';

describe('SalonService', () => {

  let httpMock: HttpTestingController;
  let service: SalonService;

  const apiEndpoint = `${environment.endpoint}salones`;

  const dummy = [
    new Salon(1, 1, 1),
    new Salon(2, 2, 1)
  ];

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ SalonService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(SalonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
    const salonService: SalonService = TestBed.inject(SalonService);
    expect(salonService).toBeTruthy();
  });

  it('deberia crear un salon', () => {
    service.guardar(dummy[0]).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpoint);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });
});
