import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoverageZoneComponent } from './coverage-zone.component';

describe('CoverageZoneComponent', () => {
  let component: CoverageZoneComponent;
  let fixture: ComponentFixture<CoverageZoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoverageZoneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CoverageZoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
