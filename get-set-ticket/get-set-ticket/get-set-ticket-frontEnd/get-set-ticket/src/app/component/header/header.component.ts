import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AuthguardGuard } from 'src/app/guard/authguard.guard';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public auth:AuthguardGuard, private router:Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.auth.loggedinUserName = '';
    this.router.navigate(['login']);
  }

}
