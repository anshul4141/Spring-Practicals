import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html'
})
export class UserListComponent implements OnInit {

  constructor(private httpService: HttpServiceService, private router: Router) { }

  ngOnInit(): void {
    this.search();
  }


  form: any = {
    list: [],
    errorMessage: '',
    successMessage: '',
    pageNo: 0,
    searchParam: {},
    deleteParam: {}
  }

  next() {
    this.form.pageNo++;
    this.search();
  }

  previous() {
    this.form.pageNo--;
    this.search();
  }

  onClickChecbox(id: any) {
    this.form.deleteParam.id = id;
  }

  delete() {
    this.httpService.get('http://localhost:8080/User/delete/' + this.form.deleteParam.id, (response: any) => {
      if (response.success == true) {
        this.form.successMessage = response.result.message;
      }
      this.search();
    })
  }

  search() {
    this.httpService.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParam, (response: any) => {
      if (response.success == true) {
        this.form.list = response.result.data;
      }
      if (response.success == false) {
        this.form.errorMessage = response.result.message;
      }
    })
  }

  edit(page: any) {
    console.log("page ==> ", page);
    this.router.navigateByUrl(page);
  }

}
