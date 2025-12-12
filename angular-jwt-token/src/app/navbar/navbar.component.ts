import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  form: any = {
    data: {}
  }

  constructor(private router: Router, private httpService: HttpServiceService) { }

  isLogin() {
    let check = localStorage.getItem('firstName');
    if (check != "null" && check != null) {
      this.form.data.firstName = localStorage.getItem("firstName");
      this.form.data.roleName = localStorage.getItem("roleName");
      this.form.data.id = localStorage.getItem("id");
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('/login')
  }
}
