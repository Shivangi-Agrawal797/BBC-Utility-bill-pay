import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
 


})
export class LoginComponent{

  username: string = '';
  password: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    // You can implement your login logic here
    if (this.username === 'yourUsername' && this.password === 'yourPassword') {
      // Authentication successful, you can redirect to another page or perform other actions
      console.log('Login successful');
    } else {
      // Authentication failed, display an error message or handle it as needed
      console.log('Login failed');
    }
  }
}
