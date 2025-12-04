import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpServiceService } from '../http-service.service';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  form: any = {
    list: [],
    searchParams: {},
    pageNo: 0
  }

  constructor(private httpService: HttpServiceService, private router: Router) {

  }

  ngOnInit(): void {
    this.search();
  }

  previous() {
    this.form.pageNo--;
    this.search();
  }

  next() {
    this.form.pageNo++;
    this.search();
  }

  search() {
    var self = this
    this.httpService.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParams, function (res: any) {
      console.log("res ==> ", res);
      self.form.list = res.result.data;
    })
  }

}
