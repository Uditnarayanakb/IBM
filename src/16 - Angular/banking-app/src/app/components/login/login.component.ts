import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username = '';
  password = '';
  message = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  login(): void {

    const result = this.authService.login(
      this.username,
      this.password
    );

    if (result) {

      this.message = 'Login Successful';

      this.router.navigate([
        '/transfer'
      ]);

    } else {

      this.message = 'Invalid Credentials';

    }

  }

}