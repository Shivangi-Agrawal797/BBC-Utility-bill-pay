import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = "http://localhost:9095/api/login/"

  constructor(private httpClient: HttpClient) { }

  
}
