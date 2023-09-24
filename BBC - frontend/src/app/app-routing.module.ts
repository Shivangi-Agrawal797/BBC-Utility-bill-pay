import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { BillsComponent } from './component/bills/bills.component';
import { ProfileComponent } from './component/profile/profile.component';
import { PaymentHistoryComponent } from './component/payment-history/payment-history.component';

const routes: Routes = [
  {
    path:'home',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
    path:"login",
    component:LoginComponent,
    pathMatch:'full'
  },
  {
    path:"dashboard",
    component:DashboardComponent,
    pathMatch:'full'
  },
  {
    path: 'bills',
    component: BillsComponent, // Add the Bills component route.
  },
  { path: 'profile', 
  component: ProfileComponent 
  },
  { path: 'payment-history', 
  component: PaymentHistoryComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
