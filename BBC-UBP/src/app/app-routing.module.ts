import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { BillsComponent } from './component/bills/bills.component';
import { ProfileComponent } from './component/profile/profile.component';
import { PaymentHistoryComponent } from './component/payment-history/payment-history.component';
import { PaidComponent } from './component/paid/paid.component';
import { UnpaidComponent } from './component/unpaid/unpaid.component';

const routes: Routes = [
  {
    path:"",
    component:HomeComponent,
  },
  {
    path:"login",
    component:LoginComponent,
  },
  {
    path:"dashboard",
    component:DashboardComponent,
  },
  {
    path: 'bills',
    component: BillsComponent, // Add the Bills component route.
    pathMatch:'full'
  },
  { path: 'profile', 
  component: ProfileComponent,
  pathMatch:'full'
  },
  { path: 'payment-history', 
  component: PaymentHistoryComponent,
  pathMatch:'full'
  },
  { path: 'paid', 
  component: PaidComponent,
  
  },
  { path: 'unpaid', 
  component: UnpaidComponent,
 
  },
  { path: 'logout', 
  component: HomeComponent,
  pathMatch:'full'
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
