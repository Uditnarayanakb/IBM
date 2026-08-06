import { Routes } from '@angular/router';

// import { DashboardComponent }
// from './dashboard/dashboard.component';
import { DashboardComponent } from './dashboard/dashboard';

// import { TransactionsComponent }
// from './transaction/transaction.component';

import { TransactionsComponent } from './transaction/transaction';

export const routes: Routes = [

  {
    path: 'dashboard',
    component: DashboardComponent
  },

  {
    path: 'transactions',
    component: TransactionsComponent
  },

  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full'
  }
];