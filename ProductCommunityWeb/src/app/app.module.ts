import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { LoginComponent } from './login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HomePageComponent } from './home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { LoginAdminComponent } from './components/login-admin/login-admin.component';
import { UserHomeComponent } from './components/home/user-home/user-home.component';
import { AdminHomeComponent } from './components/home/admin-home/admin-home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HomeDashboardComponent } from './components/home-dashboard/home-dashboard.component';



@NgModule({
  declarations: [
    AppComponent,
    FrontPageComponent,
    LoginComponent,
    HomePageComponent,
    RegisterUserComponent,
    LoginUserComponent,
    LoginAdminComponent,
    UserHomeComponent,
    AdminHomeComponent,
    HomeDashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
