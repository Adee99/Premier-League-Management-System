import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SportsClubListComponent } from './sports-club-list.component';

describe('SportsClubListComponent', () => {
  let component: SportsClubListComponent;
  let fixture: ComponentFixture<SportsClubListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SportsClubListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SportsClubListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
