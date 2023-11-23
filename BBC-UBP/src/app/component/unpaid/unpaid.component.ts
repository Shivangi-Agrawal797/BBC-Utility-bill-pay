import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-unpaid',
  templateUrl: './unpaid.component.html',
  styleUrls: ['./unpaid.component.css']
})
export class UnpaidComponent implements OnInit {

   unpaidbill : any

   billId : any;

  constructor(private unpaidService : LoginService) { }
  ngOnInit(): void {
    this.billId = sessionStorage.getItem("billId");
    console.log(this.billId);
    this.getunpaidbill();

  }

  getunpaidbill(){
    console.log("billId")
    this.unpaidService.getallbill(this.billId).subscribe((data : any)=>{
          console.log(data);
          this.unpaidbill= data;
          console.log(this.unpaidbill)
  },(error)=>{
    console.log(error.error);
  })
  }

}
