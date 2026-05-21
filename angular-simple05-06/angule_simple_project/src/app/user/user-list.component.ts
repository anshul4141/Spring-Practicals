import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private httpService: HttpServiceService, private router: Router) { }

  form: any = {
    list: [],
    searchParam: {},
    pageNo: 0,
    deleteParams: [],
    message: ''
  }

  ngOnInit(): void {
    this.search();
  }

  next() {
    this.form.pageNo++;
    this.search();
  }

  previous() {
    this.form.pageNo--;
    this.search();
  }

  search() {
    let self = this;
    this.httpService.post('http://localhost:8081/User/search/' + this.form.pageNo, this.form.searchParam, (response: any) => {
      console.log('response === >', response);
      if (response.success == true) {
        self.form.list = response.result.data;
      }
    });
  }

  onClickCheckBox(userId: any) {
    this.form.deleteParams = userId;
  }

  delete() {
    var self = this
    this.httpService.get('http://localhost:8081/User/delete/' + this.form.deleteParams, function (response: any) {
      if (response.success == true && response.result.message) {
        self.form.message = response.result.message;
      }
      self.search()
    })
  }

  edit(page: any) {
    console.log("page ==> ", page);
    this.router.navigateByUrl(page);
  }

  reset() {
    location.reload();
    // this.form.searchParam = {};
    // this.search();
  }

}