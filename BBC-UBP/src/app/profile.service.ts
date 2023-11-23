import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { customer } from './model/customer';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private baseUrl="http://localhost:9095/api/customer/1";

  constructor(private httpClient : HttpClient) { }

  // getCustomers():{
  //   return this.httpClient.get<customer[]>(`${this.baseUrl}`)
  // }
  
}
