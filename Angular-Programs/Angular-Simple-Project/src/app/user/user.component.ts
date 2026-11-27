import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent implements OnInit {

  endpoint: any = 'http://localhost:8080/User/save';

  form: any = {
    data: {},
    errorMessage: '',
    successMessage: '',
    inputerror: {}
  }

  selectedFile: any

  constructor(private httpService: HttpserviceService, private activatedRoute: ActivatedRoute) {

    this.activatedRoute.params.subscribe((params: any) => {
      this.form.data.id = params["id"];
      console.log(this.form.data.id)
    })

  }

  ngOnInit() {
    if (this.form.data.id) {
      this.display();
    }
  }

  display() {

    this.httpService.get('http://localhost:8080/User/get/' + this.form.data.id, (response: any) => {
      if (response.success == true) {
        this.form.data = response.result.data;
      } else {
        this.form.errorMessage = 'record not found'
      }

    })
  }

  save() {
    this.form.errorMessage = ''
    this.form.successMessage = ''
    this.form.inputerror = {}
    // console.log('form data:', this.form.data)
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log('response:', response)

      if (response.success == false && response.result.inputerror) {
        this.form.inputerror = response.result.inputerror;
      }

      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
      }

      if (response.success == true) {
        this.form.successMessage = response.result.message;
        this.form.data = response.result.data;
      }

      if (this.selectedFile) {
        this.myFile()
      }

    });
  }

  onChageProfilePic(event: any) {
    this.selectedFile = event.target.files.item(0);
    console.log("profile pic:", this.selectedFile)
  }

  myFile() {
    const formData = new FormData();
    formData.append('file', this.selectedFile);
    this.httpService.post('http://localhost:8080/User/profilePic/' + this.form.data.id, formData, (response: any) => {
      console.log('response:', response);
    })

  }

}




