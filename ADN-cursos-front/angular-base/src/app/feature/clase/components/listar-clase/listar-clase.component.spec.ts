import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Clase } from '@clase/shared/model/clase';
import { ClaseService } from '@clase/shared/service/clase.service';
import { HttpService } from '@core/services/http.service';
import { ListarClaseComponent } from './listar-clase.component';
import { of } from 'rxjs/internal/observable/of';


describe('ListarClaseComponent', () => {
  let component: ListarClaseComponent;
  let fixture: ComponentFixture<ListarClaseComponent>;
  let claseService: ClaseService;

  const listaClase: Clase [] = [
    new Clase(1, 'Clase 1', 1, 1),
    new Clase(2, 'Clase 2', 1, 2)
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarClaseComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
      ],
      providers: [ClaseService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarClaseComponent);
    component = fixture.componentInstance;
    claseService = TestBed.inject(ClaseService);
    spyOn(claseService, 'consultar').and.returnValue(
      of(listaClase)
    );
    spyOn(claseService, 'eliminar').and.returnValue(
      of(true)
    );
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.displayedColumns.length).toBe(4);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagClases).toBeFalsy();
  });

  it('despues de ejecutar el clase service', () => {
    fixture.detectChanges();
    expect(component.dataSource.length).toBe(2);
    expect(component.flagClases).toBeTruthy();
  });

  it('eliminar una clase', () => {
    fixture.detectChanges();
    component.eliminar(listaClase[0]);
    expect(component.dataSource.length).toBe(1);
    expect(component.flagClases).toBeTruthy();

    component.eliminar(listaClase[1]);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagClases).toBeFalsy();
  });

});
