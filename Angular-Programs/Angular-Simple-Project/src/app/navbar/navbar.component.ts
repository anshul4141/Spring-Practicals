import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  form: any = {
    data: {}
  }

  constructor(private router: Router){}

  isLogin() {

    let check = localStorage.getItem('firstName')

    if (check != null && check != '' && check != undefined) {
      this.form.data.firstName = check;
      this.form.data.roleName = localStorage.getItem('roleName');
      this.form.data.id = localStorage.getItem('id');
      return true;
    }

    return false;

  }

  logout(){
    localStorage.clear();
    this.router.navigateByUrl('login?successMessage=Logout Successfully')
  }

}
