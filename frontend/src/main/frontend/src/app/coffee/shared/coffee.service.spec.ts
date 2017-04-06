/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CoffeeServiceService } from './coffee-service.service';

describe('CoffeeServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CoffeeServiceService]
    });
  });

  it('should ...', inject([CoffeeServiceService], (service: CoffeeServiceService) => {
    expect(service).toBeTruthy();
  }));
});
