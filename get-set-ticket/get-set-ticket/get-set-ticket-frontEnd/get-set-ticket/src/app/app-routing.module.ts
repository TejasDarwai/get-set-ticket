import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuyTicketComponent } from './component/buy-ticket/buy-ticket.component';
import { SellTicketComponent } from './component/sell-ticket/sell-ticket.component';
import { LoginComponent } from './component/authentication/login/login.component';
import { SignupComponent } from './component/authentication/signup/signup.component';
import { AuthguardGuard } from './guard/authguard.guard';

const routes: Routes = [
  { path: 'buy-ticket', component: BuyTicketComponent, canActivate:[AuthguardGuard] },
  { path: 'sell-ticket', component: SellTicketComponent, canActivate:[AuthguardGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
