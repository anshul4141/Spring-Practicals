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
    pageNo: 0,
    searchParam: {},
    deleteParams: [],
    preload: []
  }

  constructor(public httpService: HttpServiceService, public router: Router) { }

  ngOnInit(): void {
    this.search();
    this.preload();
  }

  preload() {
    var self = this
    this.httpService.get('http://localhost:8080/User/preload', function (res: any) {
      console.log("roleList=== ", res)
      self.form.preload = res.result.roleList;
    });
  }

  search() {
    let self = this;
    this.httpService.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParam, function (res: any) {
      console.log("res ===== > " + res.result.data)
      self.form.list = res.result.data;
    })
  }

  onCheckboxChange(userId: any) {
    this.form.deleteParams.id = userId;
    console.log('ids: ', this.form.deleteParams.id);
  }

  delete() {
    var self = this
    this.httpService.get('http://localhost:8080/User/delete/' + this.form.deleteParams.id, function (res: any) {
      if (res.success && res.result.message) {
        self.form.message = res.result.message;
      }
      self.search()
    })
  }

  edit(path: any) {
    console.log('path: ', path)
    this.router.navigateByUrl(path);
  }

  reset() {
    location.reload()
  }

}
