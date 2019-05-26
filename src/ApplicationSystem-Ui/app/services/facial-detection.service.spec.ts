import { TestBed } from '@angular/core/testing';

import { FacialDetectionService } from './facial-detection.service';

describe('FacialDetectionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FacialDetectionService = TestBed.get(FacialDetectionService);
    expect(service).toBeTruthy();
  });
});
