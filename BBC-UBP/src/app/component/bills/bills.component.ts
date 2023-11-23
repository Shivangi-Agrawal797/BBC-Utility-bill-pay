import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';
import { bills } from './bills';

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
  
})
export class BillsComponent implements OnInit {
  
  bills:any=[]
 
  id : any ;
  router : any;

  constructor(private billService: LoginService ,  router: Router ) { }
  


//   toggleStatus(bill:any): void {
//     this.router.navigate([bill.isPaid ? '/paid-route' : '/unpaid-route']);
//   }

  ngOnInit(): void {
    this.id = sessionStorage.getItem("id");
    console.log(this.id);
    this.getallbill();

   
    }

  getallbill(){
    console.log("id")
    this.billService.getallbill(this.id).subscribe((data : any)=>{
          console.log(data);
          this.bills= data;
          console.log(this.bills)
  },(error)=>{
    console.log(error.error);
  })
  
}

// markAsPaid(bill: bills): void{
//   bill.isPaid = true;
// }

// markAsUnpaid(bill: bills): void {
//   bill.isPaid = false;
// }

 

  navigateToBillDetails(bill: bills) {
    if (bill.isPaid) {
      this.router.navigate(['/paid']);
    } else {
      this.router.navigate(['/unpaid']);
    }
  }

}