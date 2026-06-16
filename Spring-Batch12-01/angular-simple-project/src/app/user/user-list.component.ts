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
    successMessage: '',
    errorMessage: '',
    pageNo: 0,
    searchParam: {},
    deleteParam: []
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

    this.httpService.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParam, (response: any) => {

      if (response.success == false) {
        this.form.errorMessage = response.result.message;
      }

      if (response.success == true && response.result.data) {
        this.form.list = response.result.data;
      }
    });

  }

  onClickCheckbox(id: any) {
    this.form.deleteParam = id;
  }

  delete() {
    this.httpService.get('http://localhost:8080/User/delete/' + this.form.deleteParam, (response: any) => {

      if (response.success == true && response.result.message) {
        this.form.successMessage = response.result.message;
        this.form.deleteParam = [];
      }

      this.search();

    });
  }

  editUser(page: any) {
    console.log("page ==> ", page);
    this.router.navigateByUrl(page);
  }

  reset() {
    location.reload();
  }

}
