import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  form: any = {
    list: [],
    searchParam: {},
    pageNo: 0,
    deleteParams: [],
    message: '',
    roleList: []
  }

  constructor(private httpService: HttpServiceService, private router: Router) { }

  ngOnInit(): void {
    console.log('user list component init');
    this.search();
    this.preload();
  }

  preload() {
    let self = this;
    this.httpService.get('http://localhost:8081/User/preload', function (res: any) {
      self.form.roleList = res.result.roleList;
    })
  }

  previous() {
    this.form.pageNo--
    this.search();
  }

  next() {
    this.form.pageNo++
    this.search();
  }

  onCheckboxChange(userId: any) {
    this.form.deleteParams.id = userId;
    console.log('ids: ', this.form.deleteParams.id);
  }

  delete() {
    if (this.form.deleteParams.id == null || this.form.deleteParams.id == undefined || this.form.deleteParams.id == '' || this.form.deleteParams.id == 'null') {
      this.form.message = 'Please select at least one record to delete';
      return;
    }

    console.log('delete user id: ', this.form.deleteParams.id);
    var self = this
    this.httpService.get('http://localhost:8081/User/delete/' + this.form.deleteParams.id, function (res: any) {
      if (res.success && res.result.message) {
        self.form.message = res.result.message;
      }
      self.search()
    })
  }

  search() {
    let self = this;
    this.httpService.post('http://localhost:8081/User/search/' + this.form.pageNo, this.form.searchParam, function (response: any) {
      console.log('response ====== ', response)

      if (response.success) {
        self.form.list = response.result.data;
        console.log('user list ====== ', self.form.list)
      }
    })
  }

  edit(path: any) {
    console.log('path: ', path)
    this.router.navigateByUrl(path);
  }

}
