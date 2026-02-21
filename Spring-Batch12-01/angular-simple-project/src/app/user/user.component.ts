import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  form: any = {
    data: {},
    inputerror: {},
    message: '',
    preload: []
  }

  constructor(private httpService: HttpServiceService, private httpClient: HttpClient, public route: ActivatedRoute) {

    this.route.params.subscribe((pathVariable: any) => {
      this.form.data.id = pathVariable['id'];
    })

  }

  ngOnInit(): void {
    this.preload();
    if (this.form.data.id && this.form.data.id > 0) {
      this.display();
    }
  }

  display() {
    var self = this;
    this.httpService.get('http://localhost:8080/User/get/' + this.form.data.id, function (res: any) {
      self.form.data = res.result.data;
    })
  }

  preload() {
    var self = this
    this.httpService.get('http://localhost:8080/User/preload', function (res: any) {
      console.log("roleList=== ", res)
      self.form.preload = res.result.roleList;
    });
  }

  save() {
    var self = this
    this.httpService.post('http://localhost:8080/User/save', this.form.data, function (res: any) {
      console.log('res => ', res)

      if (!res.success && res.result.message) {
        self.form.message = res.result.message;
      }

      if (!res.success) {
        self.form.inputerror = res.result.inputerror;
      }

      if (res.success) {
        self.form.message = res.result.message;
        self.form.data.id = res.result.data;
      }

    });
  }

}