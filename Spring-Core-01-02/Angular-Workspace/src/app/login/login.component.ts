import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  constructor(private router: Router) { }

  form: any = {

    data: {},

    errorMsg: '',
    successMsg: '',

  }

  signIn() {

    console.log(this.form.login);
    console.log(this.form.password);

    if (this.form.login == 'admin' && this.form.password == 'admin') {

      this.router.navigateByUrl('/welcome');

    } else {
      this.form.errorMsg = 'Invalid login or password';
    }

  }

  signUp() {
    this.router.navigateByUrl('/signup');
  }

}
