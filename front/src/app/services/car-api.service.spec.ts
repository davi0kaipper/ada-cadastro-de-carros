import { TestBed } from '@angular/core/testing';

import { CarApiService } from './car-api.Service';

describe('CarApiService', () => {
  let Service: CarApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    Service = TestBed.inject(CarApiService);
  });

  it('should be created', () => {
    expect(Service).toBeTruthy();
  });
});
