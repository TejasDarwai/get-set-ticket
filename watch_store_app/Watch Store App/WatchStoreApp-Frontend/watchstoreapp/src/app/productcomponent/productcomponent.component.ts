import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { customer } from 'src/Model/customer';
import { product } from 'src/Model/product';
import { AuthGuard } from '../auth.guard';
import { CompanyServiceService } from '../company-service.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-productcomponent',
  templateUrl: './productcomponent.component.html',
  styleUrls: ['./productcomponent.component.css'],
})
export class ProductcomponentComponent implements OnInit {
  constructor(
    private companyService: CompanyServiceService,
    private authService: AuthGuard,
    private router: Router,
    private customerService: CustomerService
  ) {}

  product: product = new product();

  getProduct() {
    this.companyService.findProduct().subscribe((res) => {
      this.product = res;
    });
  }

  addToCart(id: number) {
    if (this.authService.isUserLoggedIn) {
      let tempCust: customer = this.authService.customer;
      tempCust.inCartNo = tempCust.inCartNo + 1;
      tempCust.inCart = tempCust.inCart + id.toString() + ',';
      this.customerService.updateCustomer(tempCust).subscribe((res) => {
        this.authService.customer = res;
      });
    } else {
      this.router.navigate(['login']);
    }
  }

  ngOnInit(): void {
    this.getProduct();
  }
}
