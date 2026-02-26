import { Component } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  form: any = {
    data: {}
  }

  signUp() {
    console.log('firstName== ', this.form.data.firstName);
    console.log('lastName== ', this.form.data.lastName);
    console.log('loginId== ', this.form.data.loginId);
    console.log('password== ', this.form.data.password);
    console.log('dob== ', this.form.data.dob);
  }

}
