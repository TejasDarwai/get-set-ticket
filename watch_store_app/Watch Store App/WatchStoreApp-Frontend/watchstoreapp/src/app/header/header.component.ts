import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthGuard } from '../auth.guard';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router, public auth:AuthGuard) { }

  ngOnInit(): void {
  }

  goToLogin(){
    this.router.navigate(['login']);
  }

  logout(){
    this.auth.deleteUserName();
    this.router.navigate(['home'])
  }

}
