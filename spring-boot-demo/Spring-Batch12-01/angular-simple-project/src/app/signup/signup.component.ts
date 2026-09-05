import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  constructor(private httpService: HttpServiceService) { }

  endpoint: any = 'http://localhost:8080/Auth/signup'

  form: any = {
    data: {},
    successMessage: '',
    errorMessage: '',
    inputError: {},
  }

  signUp() {
    console.log('form data ====> ', this.form.data)
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log('response ===> ', response)
      if (response.success == true && response.result.message) {
        this.form.successMessage = response.result.message;
      }
      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
      }
      if (response.success == false && response.result.inputerror) {
        this.form.inputError = response.result.inputerror;
      }
    })
  }

}
