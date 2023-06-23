import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { company } from 'src/Model/company';
import { Observable, of } from 'rxjs'; 
import { product } from 'src/Model/product';

@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {

  constructor(private http:HttpClient) { 

  }

  companyId:number = 10;
  productId:number = 1;

  findAll(): Observable<company[]> {
    return this.http.get<company[]>('http://localhost:8080/api/company');
  }

  findLatestProducts(): Observable<product[]> {
    
    return this.http.get<product[]>('http://localhost:8080/api/product/latest/1');
  }

  findCompanyProducts(): Observable<product[]> {
    return this.http.get<product[]>('http://localhost:8080/api/product/company/'+this.companyId);
  }

  findSmartProducts(): Observable<product[]> {
    return this.http.get<product[]>('http://localhost:8080/api/product/smart/1');
  }

  findproduct(id:number):Observable<product>{
    return this.http.get<product>('http://localhost:8080/api/product/'+id);
  }

  findProduct():Observable<product>{
    return this.http.get<product>('http://localhost:8080/api/product/'+this.productId);
  }
}
