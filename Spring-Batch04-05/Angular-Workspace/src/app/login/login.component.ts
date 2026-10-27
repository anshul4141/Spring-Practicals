import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  form: any = {
    data: {},
    errorMessage: ''
  }

  constructor(private router: Router) { }

  signIn() {

    console.log('login: ', this.form.data.login);
    console.log('password: ', this.form.data.password)

    if (this.form.data.login == 'admin' && this.form.data.password == 'admin') {
      this.router.navigateByUrl('/welcome');
    } else {
      this.form.errorMessage = 'Invalid login or password';
    }

  }

}
