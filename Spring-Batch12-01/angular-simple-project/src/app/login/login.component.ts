import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  endpoint = 'http://localhost:8080/Auth/login';

  constructor(public httpService: HttpServiceService, public router: Router) { }

  form: any = {
    data: {},
    message: '',
    inputerror: {}
  }

  signIn() {
    let self = this;

    this.httpService.post(this.endpoint, this.form.data, function (res: any) {
      if (!res.success && res.result.message) {
        self.form.message = res.result.message;
      }

      if (!res.success && res.result.inputerror) {
        self.form.inputerror = res.result.inputerror;
      }

      if (res.success) {
        localStorage.setItem('firstName', res.result.data.firstName)
        localStorage.setItem('role', res.result.data.roleName)
        localStorage.setItem('id', res.result.data.id)
        self.router.navigateByUrl('welcome');
      }

    });

  }

  signUp() {
    this.router.navigateByUrl('/signup');
  }

}
