import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {

  transferFunds(
    balance: number,
    amount: number
  ): string {

    if (amount <= 0) {
      return 'Please enter a valid amount';
    }

    if (amount > balance) {
      return 'Insufficient Balance';
    }

    const remainingBalance = balance - amount;

    return `Transfer Successful. Remaining Balance: ₹${remainingBalance}`;
  }
}