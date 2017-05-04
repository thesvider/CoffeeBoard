/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
//import { CoffeeServiceService } from './coffee-service.service';
import {CoffeeService} from "./coffee.service";

describe('CoffeeServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CoffeeService]
    });
  });

  it('should ...', inject([CoffeeService], (service: CoffeeService) => {
    expect(service).toBeTruthy();
  }));
});
