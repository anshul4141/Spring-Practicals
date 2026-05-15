import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(public httpService: HttpServiceService) { }

  endpoint: any = "http://localhost:8081/Auth/login"

  form: any = {
    data: {},
    inputerror: {},
    message: '',
    errorMessage: ''
  }

  signIn() {
    let self = this;
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log('response === >', response);
      if (response.success == false && response.result.inputerror) {
        self.form.inputerror = response.result.inputerror;
      } else if (response.success == false && response.result.message) {
        self.form.errorMessage = response.result.message;
      } else if (response.success == true) {
        self.form.message = response.result.message;
      }
    });
  }

}
