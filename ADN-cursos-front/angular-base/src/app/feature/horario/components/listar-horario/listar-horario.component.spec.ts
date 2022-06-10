import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpService } from '@core/services/http.service';
import { Horario } from '@horario/shared/model/horario';
import { HorarioService } from '@horario/shared/service/horario.service';
import { of } from 'rxjs/internal/observable/of';

import { ListarHorarioComponent } from './listar-horario.component';

describe('ListarHorarioComponent', () => {
  let component: ListarHorarioComponent;
  let fixture: ComponentFixture<ListarHorarioComponent>;
  let service: HorarioService;

  const listaHorarios = [
    new Horario('1', 1, 1, 8, 2),
    new Horario('2', 2, 2, 10, 1)
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarHorarioComponent ],
      imports: [
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
      ],
      providers: [ HorarioService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarHorarioComponent);
    component = fixture.componentInstance;
    service = TestBed.inject(HorarioService);
    spyOn(service, 'consultar').and.returnValue(
      of(listaHorarios)
    );
    spyOn(service, 'eliminar').and.returnValue(
      of(true)
    );
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    expect(component.displayedColumns.length).toBe(5);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagHorarios).toBeFalsy();
  });

  it('despues de ejecutar el horario service', () => {
    fixture.detectChanges();
    expect(component.dataSource.length).toBe(2);
    expect(component.flagHorarios).toBeTruthy();
  });

  it('eliminar un horario', () => {
    fixture.detectChanges();
    component.eliminar(listaHorarios[0]);
    expect(component.dataSource.length).toBe(1);
    expect(component.flagHorarios).toBeTruthy();

    component.eliminar(listaHorarios[1]);
    expect(component.dataSource.length).toBe(0);
    expect(component.flagHorarios).toBeFalsy();
  });
});
