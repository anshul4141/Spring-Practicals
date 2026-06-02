import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router: Router, private httpService: HttpServiceService) { }

  form: any = {
    data: {}
  }

  isLogin() {
    let check = localStorage.getItem('firstName');

    if (check != null && check != undefined && check != '' && check != 'null' && check != 'undefined') {
      this.form.data.firstName = check;
      this.form.data.roleName = localStorage.getItem('roleName');
      this.form.data.id = localStorage.getItem('id');
      return true;
    }
    return false;
  }

  logout() {
    localStorage.clear();
    this.httpService.get('http://localhost:8081/Auth/logout', function (response: any) {
      console.log('response === >', response);
    });
    this.router.navigateByUrl('/login');
  }

}
