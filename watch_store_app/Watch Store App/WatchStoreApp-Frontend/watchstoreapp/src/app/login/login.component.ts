import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { customer } from 'src/Model/customer';
import { AuthGuard } from '../auth.guard';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(
    private router: Router,
    private authService: AuthGuard,
    private http: HttpClient,
    private service:CustomerService
  ) {}

  foundCustomer = new customer();
  registerCustomer = new customer();
  activeCustomer = new customer();

  showLogIn:boolean = true;
  showSignUp:boolean = false;

  ngOnInit(): void {}

  showSignup(){
    this.showSignUp = true;
    this.showLogIn = false;
  }

  showLogin(){
    this.showSignUp = false;
    this.showLogIn = true;
  }

  performLogin() {
    this.service.performLogin(this.foundCustomer).subscribe((response) => {
      sessionStorage.setItem('customername', this.foundCustomer.emailId);
      this.authService.username = this.foundCustomer.emailId;
      this.authService.saveUserName();
      this.getCustomerData(this.foundCustomer);
      this.router.navigate(['home']); 
    });
  }

  performSignUp(){
    this.service.performSignUp(this.registerCustomer).subscribe((Response) => {
      sessionStorage.setItem('customername', this.foundCustomer.emailId);
      this.authService.username = this.foundCustomer.emailId;
      this.authService.saveUserName();
      this.router.navigate(['home']);
    })
  }

  getCustomerData(customer:customer){
    this.service.getCustomerData(customer).subscribe((response) => {
      this.foundCustomer = response;
      this.authService.customer = response;
    })
  }
}
