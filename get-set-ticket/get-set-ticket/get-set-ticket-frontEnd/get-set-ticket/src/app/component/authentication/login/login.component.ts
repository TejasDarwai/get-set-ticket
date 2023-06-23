import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthguardGuard } from 'src/app/guard/authguard.guard';
import { User } from 'src/app/model/User';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private formBuilder:FormBuilder, private router:Router, private loginService:AuthenticationService, private auth:AuthguardGuard) { }

  loginForm: FormGroup | any;
  user:User = {} as User;



  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: [''],
      password:['']
    })
  }

  login(){
    this.user.email = this.loginForm.get('email').value;
    this.user.password = this.loginForm.get('password').value;
    this.loginService.login(this.user).subscribe((response)=>{
      sessionStorage.setItem('user', response.userId);
       this.loginService.loggedInUser = response.userId;
       this.auth.loggedinUserName = response.name;
       this.auth.loggedinUserId = response.userId;
       alert('Login Successful, redirecting to Buy Ticket');
          setTimeout(() => {
            this.router.navigate(['buy-ticket']);
          }, 2000);
      },
        error => {
          alert('Invalid User Details');
          this.loginForm.reset();
        }
      );
  }

  navigateToSignUp(){
    this.router.navigate(['signup']);
  }


}
