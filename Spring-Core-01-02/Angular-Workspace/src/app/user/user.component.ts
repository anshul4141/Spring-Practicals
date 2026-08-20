import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent implements OnInit {

  form: any = {
    data: {},
    errorMsg: '',
    successMsg: '',
    inputerror: {},
    roleList: []
  }

  ngOnInit(): void {
    this.preload();
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
    this.httpService.get('http://localhost:8080/User/get/' + this.form.data.id, (response: any) => {
      this.form.data = response.result.data;
      this.form.data.dob = response.result.data.dob.substring(0, 10);
    })
  }

  preload() {
    this.httpService.get('http://localhost:8080/User/preload', (response: any) => {
      this.form.roleList = response.result.roleList;
    })
  }

  save() {
    this.form.errorMsg = '';
    this.form.successMsg = '',
      this.form.inputerror = {}

    this.httpService.post('http://localhost:8080/User/save', this.form.data, (response: any) => {
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
    })

  }

}
