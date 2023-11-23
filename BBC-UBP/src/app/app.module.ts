import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatButtonModule} from '@angular/material/button';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule} from '@angular/forms';
import { BillsComponent } from './component/bills/bills.component';
import { ProfileComponent } from './component/profile/profile.component';
import { PaymentHistoryComponent } from './component/payment-history/payment-history.component'
import {MatTableModule} from '@angular/material/table';
import { PaidComponent } from './component/paid/paid.component';
import { UnpaidComponent } from './component/unpaid/unpaid.component';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    BillsComponent,
    ProfileComponent,
    PaymentHistoryComponent,
    PaidComponent,
    UnpaidComponent
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatTableModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
