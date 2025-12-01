import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private httpService: HttpServiceService ) { }

  endpoint: string = 'http://localhost:8080/Auth/signUp'

  form: any = {
    data: {},
    message: ''
  }

  signUp() {
    console.log('in signUp() function')
    console.log('firstName==> ', this.form.data.firstName)
    console.log('lastName===>', this.form.data.lastName)
    console.log('login===>', this.form.data.loginId)
    console.log('password===>', this.form.data.password)
    console.log('dob===>', this.form.data.dob)

    this.httpService.post(this.endpoint, this.form.data, function (res: any) {
      console.log('response from signUp api===>', res)
    })


  }
}
