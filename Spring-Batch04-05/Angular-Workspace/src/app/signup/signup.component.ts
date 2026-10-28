import { Component } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent {

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror: {}
  }

  constructor(private httpService: HttpserviceService) { }

  signUp() {

    this.form.errorMessage = '',
      this.form.successMessage = '',
      this.form.inputerror = {}

    console.log("form data: ", this.form.data)

    this.httpService.post('http://localhost:8080/Auth/signUp', this.form.data, (response: any) => {

      console.log("response: ", response)

      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
      }

      if (response.success == true && response.result.message) {
        this.form.successMessage = response.result.message
      }


    });
  }
}
