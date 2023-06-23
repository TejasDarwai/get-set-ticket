import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  loggedInUser:any = '';

  login(user:User): Observable<any>{
    return this.http.post<User>('http://localhost:8080/users/login', user);
  }

  signUp(user: User): Observable<any>{
    return this.http.post<User>('http://localhost:8080/users/create', user);
  }
}
