import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayedmatchesListComponent } from './playedmatches-list.component';

describe('PlayedmatchesListComponent', () => {
  let component: PlayedmatchesListComponent;
  let fixture: ComponentFixture<PlayedmatchesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlayedmatchesListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayedmatchesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
