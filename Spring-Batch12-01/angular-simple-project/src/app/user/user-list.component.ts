import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private httpService: HttpServiceService) { }

  form: any = {
    list: [],
    successMessage: '',
    errorMessage: '',
    pageNo: 0,
    searchParam: {}
  }

  ngOnInit(): void {
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

  reset(){
    location.reload();
  }

}
