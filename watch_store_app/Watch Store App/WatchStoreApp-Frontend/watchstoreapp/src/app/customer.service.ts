import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { customer } from 'src/Model/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  constructor(private http: HttpClient) {}

  performLogin(customer: customer) {
    return this.http.post(
      'http://localhost:8080/api/customer/login',
      customer,
      {
        responseType: 'text',
      }
    );
  }

  performSignUp(customer: customer): Observable<customer> {
    return this.http.post<customer>(
      'http://localhost:8080/api/customer/registercustomer',
      customer
    );
  }

  getCustomerData(customer: customer): Observable<customer> {
    let credentials = customer.emailId + ':' + customer.password; 
    let encodedCredentials = btoa(credentials);
    let headers = new HttpHeaders().append(
      'Authorization',
      'Basic ' + encodedCredentials
    );
    console.log(credentials);
    return this.http.get<customer>(
      'http://localhost:8080/api/customer/' + customer.emailId
    );
  }

  updateCustomer(customer: customer): Observable<customer> {
    console.log('in add to cart, service');
    return this.http.post<customer>(
      'http://localhost:8080/api/customer/update',
      customer
    );
  }
}
