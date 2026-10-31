import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent {

  form: any = {
    data: {}
  }

  isLogin() {

    let check = localStorage.getItem('firstName');

    if (check != null && check != undefined && check != '') {
      this.form.data.firstName = check;
      this.form.data.roleName = localStorage.getItem('roleName');
      this.form.data.id = localStorage.getItem('id');
      return true;
    }

    return false;

  }

  logout() {

    localStorage.clear();
    

  }

}
