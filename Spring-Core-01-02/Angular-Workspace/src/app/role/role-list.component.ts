import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html'
})
export class RoleListComponent implements OnInit {

  constructor(private httpService: HttpServiceService) { }

  ngOnInit(): void {
    this.search();
  }


  form: any = {
    list: [],
    errorMessage: '',
    successMessage: '',
    pageNo: 0,
    searchParam: {}
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
    this.httpService.post('http://localhost:8080/Role/search/' + this.form.pageNo, this.form.searchParam, (response: any) => {
      if (response.success == true) {
        this.form.list = response.result.data;
      }
      if (response.success == false) {
        this.form.errorMessage = response.result.message;
      }
    })
  }

}
