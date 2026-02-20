import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  form: any = {
    list: [],
    pageNo: 0,
    searchParam: {}
  }

  constructor(public httpService: HttpServiceService) { }

  ngOnInit(): void {
    this.search();
  }

  search() {
    let self = this;
    this.httpService.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParam, function (res: any) {
      console.log("res ===== > " + res.result.data)
      self.form.list = res.result.data;
    })
  }

  reset() {
    location.reload()
  }

}
