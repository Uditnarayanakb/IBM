import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css'
})
export class LoginFormComponent {

  transferForm: FormGroup;

  constructor(private fb: FormBuilder) {

    this.transferForm = this.fb.group({

      fromAccount: ['', Validators.required],

      toAccount: ['', Validators.required],

      amount: [
        '',
        [
          Validators.required,
          Validators.min(100)
        ]
      ]

    });

  }

  transfer(): void {

    console.log(this.transferForm.value);

  }

}