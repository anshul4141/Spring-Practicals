import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';

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
    pageNo: 0
  }

  constructor(private httpservice: HttpserviceService) { }

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
    this.form.errorMessage = ''
    this.form.successMessage = ''

    this.httpservice.post('http://localhost:8080/User/search/' + this.form.pageNo, this.form.searchParam, (response: any) => {

      if (response.success == true) {
        this.form.list = response.result.data;
        console.log('user list:', this.form.list)
      } else {
        this.form.errorMessage = 'record not found'
      }

    })

  }

  reset(){
    location.reload();
  }

}
