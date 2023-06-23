import { TestBed } from '@angular/core/testing';

import { SellTicketService } from './sell-ticket.service';

describe('SellTicketService', () => {
  let service: SellTicketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SellTicketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
