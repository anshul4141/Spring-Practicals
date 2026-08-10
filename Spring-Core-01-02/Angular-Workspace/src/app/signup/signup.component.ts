import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent {

  constructor(private httpService: HttpServiceService) { }

  endpoint = 'http://localhost:8080/Auth/signUp';

  form: any = {
    data: {},
    errorMsg: '',
    successMsg: '',
    inputerror: {},

  }

  signUp() {

    this.form.errorMsg = ''
    this.form.successMsg = ''
    this.form.inputerror = {}

    this.httpService.post(this.endpoint, this.form.data, (response: any) => {

      console.log("response: ", response);

      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
        return;
      }

      if (response.success == false && response.result.message) {
        this.form.errorMsg = response.result.message;
        return;
      }

      if (response.success == true) {
        this.form.successMsg = response.result.message;
      }

    });

  }

}
