import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarClaseComponent } from './listar-clase.component';

describe('ListarClaseComponent', () => {
  let component: ListarClaseComponent;
  let fixture: ComponentFixture<ListarClaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarClaseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarClaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
