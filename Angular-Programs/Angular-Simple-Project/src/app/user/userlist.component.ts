import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html'
})
export class UserlistComponent implements OnInit {

  form: any = {
    list: [],
    searchParam: {},
    errorMessage: '',
    successMessage: '',
    pageNo: 0,
    ids: []
  }

  constructor(private httpservice: HttpserviceService, private router: Router) { }

  ngOnInit(): void {
    console.log('in user list ngOnInit method');
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
    // this.form.errorMessage = ''
    // this.form.successMessage = ''

    this.httpservice.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParam, (response: any) => {

      if (response.success == true) {
        this.form.list = response.result.data;
        console.log('user list:', this.form.list)
      } else {
        this.form.errorMessage = 'record not found'
      }

    })

  }

  onClickCheckBox(id: any) {
    this.form.ids = id;
    console.log('delete id ==', this.form.ids)
  }

  delete() {
    this.httpservice.get('http://localhost:8080/User/delete/' + this.form.ids, (response: any) => {
      if (response.success == true) {
        this.form.successMessage = response.result.message
      }
      this.search();
    })
  }

  edit(url: any) {
    this.router.navigateByUrl(url);
  }

  reset() {
    location.reload();
  }

}
