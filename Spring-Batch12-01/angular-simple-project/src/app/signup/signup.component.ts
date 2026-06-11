import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  form: any = {
    data: {},
    successMessage: '',
    errorMessage: '',
    inputError: {},
  }

  signUp() {

    console.log('form data ====> ', this.form.data)

  }

}
