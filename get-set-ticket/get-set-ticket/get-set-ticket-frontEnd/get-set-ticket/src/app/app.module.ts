import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { GroupUiModule } from '@group-ui/group-ui-angular';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/authentication/login/login.component';
import { HeaderComponent } from './component/header/header.component';
import { SellTicketComponent } from './component/sell-ticket/sell-ticket.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SignupComponent } from './component/authentication/signup/signup.component';
import { BuyTicketComponent } from './component/buy-ticket/buy-ticket.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    BuyTicketComponent,
    SellTicketComponent,
    SignupComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    GroupUiModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
