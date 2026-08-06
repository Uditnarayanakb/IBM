import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FundTransferService {

  transferFunds(
    fromAccount: string,
    toAccount: string,
    amount: number
  ): string {

    return 'Transfer Successful';

  }

}