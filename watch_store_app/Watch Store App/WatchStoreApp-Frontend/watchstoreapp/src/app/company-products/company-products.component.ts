import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { product } from 'src/Model/product';
import { CompanyServiceService } from '../company-service.service';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-company-products',
  templateUrl: './company-products.component.html',
  styleUrls: ['./company-products.component.css'],
})
export class CompanyProductsComponent implements OnInit {
  constructor(private service: CompanyServiceService, private router: Router) {}

  companyProducts: product[] = [];
  companyNamee: string = 'Company';
  demo: string = 'demoserdtfyguhij';

  getCompanyProducts() {
    this.service.findCompanyProducts().subscribe((res) => {
      (this.companyProducts = res),
        (this.companyNamee = this.companyProducts[0].productCompany);
    });
  }

  productDetails(id: number) {
    this.service.productId = id;
    this.router.navigate(['product']);
  }

  ngOnInit(): void {
    this.getCompanyProducts();
  }
}
