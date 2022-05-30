import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSalonComponent } from './listar-salon.component';

describe('ListarSalonComponent', () => {
  let component: ListarSalonComponent;
  let fixture: ComponentFixture<ListarSalonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarSalonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
