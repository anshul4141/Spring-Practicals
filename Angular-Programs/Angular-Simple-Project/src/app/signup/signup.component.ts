import { Component } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  endpoint: any = 'http://localhost:8080/Auth/signUp';

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror: {}
  }

  constructor(private httpService: HttpserviceService) { }

  signUp() {
    this.form.errorMessage = ''
    this.form.successMessage = ''
    this.form.inputerror = {}
    // console.log('form data:', this.form.data)
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log('response:', response)

      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
      }

      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
      }

      if (response.success == true) {
        this.form.successMessage = response.result.message;
      }

    });
  }

}
