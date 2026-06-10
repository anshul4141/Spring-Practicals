import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  message: any = '';

  form: any = {
    login: '',
    password: ''
  }

  signIn() {

    if (this.form.login == 'admin' && this.form.password == 'admin') {
      this.message = 'user login successfully';
    } else {
      this.message = 'invalid login or password'
    }

  }

}
