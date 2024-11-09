import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmDeleteArticleComponent } from './confirm-delete-article.component';

describe('ConfirmDeleteArticleComponent', () => {
  let component: ConfirmDeleteArticleComponent;
  let fixture: ComponentFixture<ConfirmDeleteArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConfirmDeleteArticleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConfirmDeleteArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
