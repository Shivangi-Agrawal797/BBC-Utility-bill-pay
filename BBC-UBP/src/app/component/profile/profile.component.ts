import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { customer } from 'src/app/model/customer';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profile:any=<customer>{}

  id :any;

  constructor(private profileService: LoginService) { }

  ngOnInit(): void {
     this.id=sessionStorage.getItem("id");
    console.log(this.id);
    this.getCustomer();
 }

 getCustomer(){

  this.profileService.getspecificcustomer(this.id).subscribe((res:any)=>{
    console.log(res);
    this.profile =res;
    console.log(this.profile);
  },(error)=>{
    console.log(error.error);
  })
 }
}
