import { Component } from '@angular/core';
import { LoginFormComponent } from './login-form/login-form';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './app.html'
})
export class AppComponent {

}