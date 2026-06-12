import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router: Router) { }

  message: any = '';

  form: any = {
    data: {}
  }

  signIn() {

    if (this.form.data.loginId == 'admin' && this.form.data.password == 'admin') {
      this.message = 'user login successfully';
    } else {
      this.message = 'invalid login or password'
    }

  }

  signUp() {
    this.router.navigateByUrl('/signup')
  }

}
