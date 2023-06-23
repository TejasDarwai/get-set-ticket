import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthguardGuard implements CanActivate {

  loggedinUserName:string = '';
  loggedinUserId:string = '';

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      console.log('In can activate');
    let isUserLoggedIn = this.loggedinUserName
    if(isUserLoggedIn === ''){
      return false;
    }
    else{
      return true;
    }
  }
  
}
