import { TestBed } from '@angular/core/testing';

import { PlayedmatchDetailsService } from './playedmatch-details.service';

describe('PlayedmatchDetailsService', () => {
  let service: PlayedmatchDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayedmatchDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
