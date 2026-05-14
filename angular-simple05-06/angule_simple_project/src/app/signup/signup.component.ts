import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  endpoint: any = "http://localhost:8081/Auth/signup"

  form: any = {
    data: {}
  }

  constructor(public httpService: HttpServiceService) { }

  signUp() {
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log('response === >', response);
    });
  }

}
