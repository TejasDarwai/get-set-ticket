import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { customer } from 'src/Model/customer';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  username = '';
  isShowLoggedIn = true;
  isUserLoggedIn = false;
  isAdmin = false; 
  isUser = false;
  customer:customer = new customer();

  constructor(private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    console.log('In can Activate', this.isUserLoggedIn);
    if (this.isUserLoggedIn) {
      return true;
    } else {
      this.router.navigate(['login']);
      return false;
    }
  }

  saveUserName() {
    this.isShowLoggedIn = false;
    this.isUserLoggedIn = true;
  }

  deleteUserName() {
    this.isUserLoggedIn = false;
    sessionStorage.removeItem('customername');
    this.isShowLoggedIn = true;
    this.router.navigate(['login']);
    this.username = '';
  }

  
}
