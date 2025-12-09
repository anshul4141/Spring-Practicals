import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  endpoint: string = 'http://localhost:8080/Auth/login'

  form: any = {
    data: {},
    inputerror: {},
    message: ''
  }

  constructor(public router: Router, public httpService: HttpServiceService, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      if (params['errorMessage']) {
        this.form.message = params['errorMessage'];
      }
    });
  }

  signIn() {
    var self = this;
    // if (this.form.data.login == 'admin' && this.form.data.password == 'admin') {
    //   this.router.navigateByUrl('welcome')
    // } else {
    //   this.form.inputError = 'login or password is invalid'
    //   // this.router.navigateByUrl('login');
    // }

    this.httpService.post(this.endpoint, this.form.data, function (res: any) {

      console.log("data == > ", res.result.data);
      console.log("message == > ", res.result.message)
      console.log("success ==> ", res.success)
      console.log("inputerror ==> ", res.result.inputerror)

      if (!res.success && res.result.message) {
        self.form.message = res.result.message
      }

      if (res.result.inputerror) {
        self.form.inputerror = res.result.inputerror;
      }

      if (res.success) {
        localStorage.setItem('firstName', res.result.data.firstName);
        localStorage.setItem('roleName', res.result.data.roleName);
        localStorage.setItem('id', res.result.data.id);
        self.router.navigateByUrl('welcome');
      }

    })

  }

}
