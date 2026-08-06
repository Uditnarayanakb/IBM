import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {

  checkBalance(amount: number): boolean {

    const availableBalance = 10000;

    return amount <= availableBalance;
  }

}