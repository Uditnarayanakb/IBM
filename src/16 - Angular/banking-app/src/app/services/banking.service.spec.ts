import { TestBed } from '@angular/core/testing';
import { BankingService } from './banking.service';

describe('BankingService', () => {

  let service: BankingService;

  beforeEach(() => {

    TestBed.configureTestingModule({});

    service =
      TestBed.inject(
        BankingService
      );

  });

  it(
    'should create the service',
    () => {

      expect(service)
        .toBeTruthy();

    }
  );

});