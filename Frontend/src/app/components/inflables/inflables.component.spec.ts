import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InflablesComponent } from './inflables.component';

describe('InflablesComponent', () => {
  let component: InflablesComponent;
  let fixture: ComponentFixture<InflablesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InflablesComponent]
    });
    fixture = TestBed.createComponent(InflablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
