import { Component } from '@angular/core';
import { CommonModule , CurrencyPipe} from '@angular/common';
import { AccountMaskPipe } from '../../pipes/account-mask.pipe';

import {
  FormArray,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import { FundTransferService } from '../../services/fund-transfer.service';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AccountMaskPipe,
    CurrencyPipe
  ],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {

  transferForm: FormGroup;

  message: string = '';

  constructor(
    private fb: FormBuilder,
    private fundTransferService: FundTransferService
  ) {

    this.transferForm = this.fb.group({

      fromAccount: [
        '',
        Validators.required
      ],

      toAccount: [
        '',
        Validators.required
      ],

      amount: [
        '',
        [
          Validators.required,
          Validators.min(100)
        ]
      ],

      beneficiaries: this.fb.array([])

    });

  }

  get beneficiaries(): FormArray {

    return this.transferForm.get(
      'beneficiaries'
    ) as FormArray;

  }

  addBeneficiary(): void {

    this.beneficiaries.push(
      this.fb.control('')
    );

  }

  removeBeneficiary(
    index: number
  ): void {

    this.beneficiaries.removeAt(index);

  }

  transfer(): void {

    const value =
      this.transferForm.value;

    this.message =
      this.fundTransferService.transferFunds(
        value.fromAccount,
        value.toAccount,
        value.amount
      );

  }

}