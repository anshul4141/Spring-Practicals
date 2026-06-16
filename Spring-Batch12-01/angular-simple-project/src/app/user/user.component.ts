import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private httpService: HttpServiceService, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe((params: any) => {
      console.log('params ===> ', params)
      if (params.id) {
        this.form.data.id = params.id;
      }
    })
  }

  endpoint: any = 'http://localhost:8080/User/save'

  form: any = {
    data: {},
    successMessage: '',
    errorMessage: '',
    inputError: {},
  }

  ngOnInit(): void {
    if (this.form.data.id) {
      this.display();
    }
  }

  reset() {
    location.reload();
  }

  display() {
    this.httpService.get('http://localhost:8080/User/get/' + this.form.data.id, (response: any) => {
      console.log('response ===> ', response)
      if (response.success == true && response.result.data) {
        this.form.data = response.result.data;
        this.form.data.dob = response.result.data.dob.substring(0, 10);
      }
    });
  }

  save() {
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
