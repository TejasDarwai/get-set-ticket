import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthguardGuard } from 'src/app/guard/authguard.guard';
import { User } from 'src/app/model/User';
import { AuthenticationService } from 'src/app/service/authentication/authentication.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private formBuilder:FormBuilder, private signupService:AuthenticationService, private auth:AuthguardGuard,private router:Router) { }

  signupForm: FormGroup | any;
  user:User = {} as User;

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      email: [''],
      password:[''],
      name:['']
    })
  }

  signUp(){
    this.user.email = this.signupForm.get('email').value;
    this.user.password = this.signupForm.get('password').value;
    this.user.name = this.signupForm.get('name').value;
    this.signupService.signUp(this.user).subscribe((response)=>{
      sessionStorage.setItem('user', response.userId);
       this.auth.loggedinUserName = response.name;
       alert('Login Successful, redirecting to Buy Ticket');
          setTimeout(() => {
            this.router.navigate(['buy-ticket']);
          }, 2000);
      },
        error => {
          alert('Invalid User Details');
          this.signupForm.reset();
        }
      );
  }

  navigateToLogin(){
    this.router.navigate(['login']);
  }

}
