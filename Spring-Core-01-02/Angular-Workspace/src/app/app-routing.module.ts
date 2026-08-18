import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { RoleComponent } from './role/role.component';
import { RoleListComponent } from './role/role-list.component';
import { UserComponent } from './user/user.component';
import { UserListComponent } from './user/user-list.component';

const routes: Routes = [

  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'welcome'
  },
  {
    path: 'welcome',
    component: WelcomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'role',
    component: RoleComponent
  },
  {
    path: 'roleList',
    component: RoleListComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'userList',
    component: UserListComponent
  },
  {
    path: 'user/:id',
    component: UserComponent
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
