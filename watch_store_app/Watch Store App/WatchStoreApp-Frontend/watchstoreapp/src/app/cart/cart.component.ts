import { Component, OnInit } from '@angular/core';
import { customer } from 'src/Model/customer';
import { product } from 'src/Model/product';
import { AuthGuard } from '../auth.guard';
import { CompanyServiceService } from '../company-service.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  constructor(
    private authService: AuthGuard,
    private companyService: CompanyServiceService
  ) {}

  productIds: number[] = [];
  products: product[] = [];
  prod: string = this.authService.customer.inCart;
  totalPrice: number = 0;

  getProducts() {
    let temp: string = '';
    for (let i = 1; i < this.prod.length; i++) {
      if (this.prod[i] == ',') {
        let num = +temp;
        this.productIds.push(num);
        temp = '';
      } else {
        temp = temp + this.prod[i];
      }
    }

    console.log(this.productIds);

    for (let i = 0; i < this.productIds.length; i++) {
      this.companyService.findproduct(this.productIds[i]).subscribe((res) => {
        (this.products[i] = res),
          (this.totalPrice = this.totalPrice + this.products[i].productPrice);
      });
    }
  }

  ngOnInit(): void {
    this.getProducts();
  }
}
