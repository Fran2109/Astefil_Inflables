import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmDeleteEmployeeComponent } from './confirm-delete-employee.component';

describe('ConfirmDeleteEmployeeComponent', () => {
  let component: ConfirmDeleteEmployeeComponent;
  let fixture: ComponentFixture<ConfirmDeleteEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConfirmDeleteEmployeeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmDeleteEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
