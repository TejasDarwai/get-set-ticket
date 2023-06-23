import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { CompanyProductsComponent } from './company-products/company-products.component';
import { RouterModule, Routes } from '@angular/router';
import { ProductcomponentComponent } from './productcomponent/productcomponent.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { CartComponent } from './cart/cart.component';

const routes:Routes = [
  {path: 'products', component:CompanyProductsComponent},
  {path: 'home', component:HomeComponent},
  {path: 'cart/home', component:HomeComponent},
  {path: 'product', component:ProductcomponentComponent},
  {path: 'login', component:LoginComponent},
  {path: 'cart', component:CartComponent, canActivate:[AuthGuard]},
  {path: '', redirectTo: 'home', pathMatch:'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CompanyProductsComponent,
    ProductcomponentComponent,
    LoginComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
