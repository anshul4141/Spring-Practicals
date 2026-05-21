import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent{

  form: any = {
    data: {},
    inputerror: {},
    message: '',
  }

  constructor(private httpService: HttpServiceService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.params.subscribe((params: any) => {
      this.form.data.id = params["id"];
      console.log('id===>', this.form.data.id)
      if (this.form.data.id) {
        this.display();
      }
    })
  }

  display() {

    var self = this
    this.httpService.get('http://localhost:8081/User/get/' + this.form.data.id, function (res: any) {
      console.log(res)
      self.form.data = res.result.data;
    });

  }

  save() {
    var self = this
    this.httpService.post('http://localhost:8081/User/save', this.form.data, function (response: any) {
      console.log('res => ', response);

      if (response.success == false && response.result.inputerror) {
        self.form.inputerror = response.result.inputerror;
      }

      if (response.success == true && response.result.message) {
        self.form.message = response.result.message;
      }

      if (response.success == true && response.result.data.id) {
        self.form.data.id = response.result.data.id;
      }

    });
  }
} 1