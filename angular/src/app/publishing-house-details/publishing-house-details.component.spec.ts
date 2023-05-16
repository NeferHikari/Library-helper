import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishingHouseDetailsComponent } from './publishing-house-details.component';

describe('PublishingHouseDetailsComponent', () => {
  let component: PublishingHouseDetailsComponent;
  let fixture: ComponentFixture<PublishingHouseDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublishingHouseDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublishingHouseDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
