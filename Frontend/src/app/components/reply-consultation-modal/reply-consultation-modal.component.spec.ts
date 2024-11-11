import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReplyConsultationModalComponent } from './reply-consultation-modal.component';

describe('ReplyConsultationModalComponent', () => {
  let component: ReplyConsultationModalComponent;
  let fixture: ComponentFixture<ReplyConsultationModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReplyConsultationModalComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReplyConsultationModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
