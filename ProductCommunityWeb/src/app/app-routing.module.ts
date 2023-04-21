import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './components/home/admin-home/admin-home.component';
import { UserHomeComponent } from './components/home/user-home/user-home.component';
import { LoginAdminComponent } from './components/login-admin/login-admin.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { FrontPageComponent } from './front-page/front-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [

  { path: "", component: FrontPageComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterUserComponent },
  { path: "login/admin", component: LoginAdminComponent },
  { path: "login/user", component: LoginUserComponent },
  { path: "homepage", component: HomePageComponent },
  {
    path: 'admin/:name', component: AdminHomeComponent
  },
  {
    path: 'user/:name', component: UserHomeComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
