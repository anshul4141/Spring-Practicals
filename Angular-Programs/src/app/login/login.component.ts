import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  form: any = {
    data: {},
    errorMsg: ''
  }

  constructor(private router: Router) { }

  login() {
    console.log("in login function")
    console.log('form data:', this.form.data.login)
    console.log('form data:', this.form.data.password)

    if (this.form.data.login == 'admin' && this.form.data.password == 'admin') {
      this.router.navigateByUrl('welcome')
    } else {
      this.form.errorMsg = 'invalid login or password'
    }

  }

}
