import { Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { LoginFormComponent } from './components/login-form/login-form.component';

import { AuthGuard } from './guards/auth.guard';

export const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },

  {
    path: 'transfer',
    component: LoginFormComponent,
    canActivate: [AuthGuard]
  }

];