import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror: {}
  }

  constructor(private router: Router, private httpService: HttpserviceService) { }

  signIn() {

    this.httpService.post('http://localhost:8080/Auth/login', this.form.data, (response: any) => {

      console.log("response: ", response)

      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
      }

      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
      }

      if (response.success == true) {
        localStorage.setItem('firstName', response.result.data.firstName)
        localStorage.setItem('roleName', response.result.data.roleName)
        localStorage.setItem('id', response.result.data.id)
        this.router.navigateByUrl('/welcome');
      }


    });

  }

}
