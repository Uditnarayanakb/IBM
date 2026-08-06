import { Component } from '@angular/core';
import { NgFor, NgIf, CurrencyPipe } from '@angular/common';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [NgFor, NgIf, CurrencyPipe],
  template: `
    <h2>Transactions</h2>

    <ul>
      <li *ngFor="let txn of transactions">
        {{ txn.date }} -
        {{ txn.amount | currency:'INR' }}
      </li>
    </ul>

    <p *ngIf="transactions.length === 0">
      No transactions found.
    </p>
  `
})
export class TransactionsComponent {

  transactions = [
    {
      date: '2026-07-30',
      amount: 2000
    },
    {
      date: '2026-07-31',
      amount: -500
    }
  ];

}