import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  baseUrl:string='http://localhost:9095/';

  constructor(private http:HttpClient) { }


  getcustomer(id:any){
    let cid=+id;
      return (this.http.get(`${this.baseUrl}api/customer/checkcustomer/${id}`,{
        responseType:'text'
      }))
  }
  
  getspecificcustomer(customerId:any){
      return this.http.get(`${this.baseUrl}api/customer/${customerId}`);
    }

  getallbill(customerId:number){
    return this.http.get(`${this.baseUrl}api/bill/customer/${customerId}`)
  }

  getunpaidbill(billId:number){
    return this.http.get(`${this.baseUrl}api/bill/${billId}`)
  }
}
