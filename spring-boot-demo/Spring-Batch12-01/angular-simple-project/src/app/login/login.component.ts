import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private router: Router, private httpService: HttpServiceService, private activatedRoute: ActivatedRoute) {
    activatedRoute.queryParams.subscribe(params => {
      if (params['errorMessage']) {
        this.form.errorMessage = params['errorMessage'];
      }
      if (params['message']) {
        this.form.successMessage = params['message'];
      }
    });
  }

  endpoint: any = 'http://localhost:8080/Auth/login'

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror: {}
  }

  signIn() {

    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
      }
      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
      }
      if (response.success == true) {

        localStorage.setItem('firstName', response.result.data.firstName);
        localStorage.setItem('roleName', response.result.data.roleName);
        localStorage.setItem('id', response.result.data.id);

        this.router.navigateByUrl('/welcome');
      }
    })

  }

  signUp() {
    this.router.navigateByUrl('/signup')
  }

}
