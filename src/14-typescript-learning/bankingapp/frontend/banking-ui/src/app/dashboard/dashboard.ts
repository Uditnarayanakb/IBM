import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FundTransferService } from '../fund-transfer';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent {

  balance: number = 10000;

  transferAmount: number = 0;

  message: string = '';

  constructor(
    private transferService: FundTransferService
  ) {}

  doTransfer(): void {

    this.message =
      this.transferService.transferFunds(
        this.balance,
        this.transferAmount
      );

    if (
      this.transferAmount > 0 &&
      this.transferAmount <= this.balance
    ) {
      this.balance =
        this.balance - this.transferAmount;
    }
  }

}