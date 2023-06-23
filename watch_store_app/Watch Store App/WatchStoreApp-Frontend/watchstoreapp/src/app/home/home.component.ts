import { Component, OnInit } from '@angular/core';
import { company } from 'src/Model/company';
import { product } from 'src/Model/product';
import { CompanyServiceService } from '../company-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  companies: company[] = [];
  // company: company = new company();
  
  latestProducts: product[] = [];
  smartProducts: product[] = [];
  

  constructor(private Service:CompanyServiceService, private router:Router) { 
    
  }

  findAllCompany(){
    this.Service.findAll().subscribe((res) => {this.companies = res;});
    
  }

  findLatestProducts(){
    this.Service.findLatestProducts().subscribe((res) => {this.latestProducts = res});
    console.log(this.latestProducts);
  }

  showCompanyProducts(id : number){
    this.Service.companyId = id;
    this.router.navigate(['products']);
  }

  findSmartProducts(){
    this.Service.findSmartProducts().subscribe((res) => {this.smartProducts = res, console.log(this.smartProducts)});
  }

  productDetails(id:number){
    this.Service.productId = id;
    this.router.navigate(['product']);
  }



  ngOnInit(): void {
    this.findLatestProducts();
    this.findAllCompany();
    this.findSmartProducts();
  }

}
