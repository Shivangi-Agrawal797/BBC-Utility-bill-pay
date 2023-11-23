import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { customer } from 'src/app/model/customer';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],

})


export class LoginComponent implements OnInit{

  credentials={
  username:'',
  password:''
  }
  obj:any=<customer>{};

  constructor(private service:LoginService,private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(formData:any): void {

    console.log(formData);
    if((this.credentials.username!='' && this.credentials.password!='')
    &&(this.credentials.username!= null && this.credentials.password!= null))

    {

      this.credentials.username = formData.value.username;
      this.credentials.password = formData.value.password;
      console.log("login successfully")
    
    }else{
      console.log("fields are empty!!!")
    }

  }
  login(Id:any, OTP:any){
      this.service.getcustomer(Id).subscribe((response)=>{
        console.log(response);
        if(response=="valid user")
        {
          sessionStorage.setItem("id",Id);
          this.router.navigate(['/dashboard'])
        }
      })
  }
}


