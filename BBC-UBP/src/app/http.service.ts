import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  baseUrl:string='http://localhost:9095/';
  constructor(private http:HttpClient) { }

  login(obj:any){
    let customerid=+obj;
    return (this.http.post(`${this.baseUrl}checkCustomerId/${customerid}`,null,));
  }

}
