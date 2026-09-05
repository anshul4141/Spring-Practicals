import { Component, OnInit } from '@angular/core';
import { HttpServiceService } from '../http-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  endpoint: any = 'http://localhost:8080/User/save'


  form: any = {
    data: {},
    successMessage: '',
    errorMessage: '',
    inputError: {},
    preload: []
  }

  fileToUpload: any = null;

  constructor(private httpService: HttpServiceService, private activatedRoute: ActivatedRoute) {
    activatedRoute.params.subscribe((params: any) => {
      console.log('params ===> ', params)
      if (params.id) {
        this.form.data.id = params.id;
      }
    })
  }


  ngOnInit(): void {

    this.preload();

    if (this.form.data.id) {
      this.display();
    }
  }

  reset() {
    location.reload();
  }

  preload() {
    this.httpService.get('http://localhost:8080/User/preload', (response: any) => {
      console.log('response ===> ', response)
      if (response.success == true && response.result.roleList) {
        this.form.preload = response.result.roleList;
      }
    });
  }

  display() {
    this.httpService.get('http://localhost:8080/User/get/' + this.form.data.id, (response: any) => {
      console.log('response ===> ', response)
      if (response.success == true && response.result.data) {
        this.form.data = response.result.data;
        this.form.data.dob = response.result.data.dob.substring(0, 10);
      }
    });
  }

  save() {
    console.log('form data ====> ', this.form.data)
    this.httpService.post(this.endpoint, this.form.data, (response: any) => {
      console.log('response ===> ', response)
      if (response.success == true && response.result.message) {
        this.form.successMessage = response.result.message;
        this.form.data = response.result.data;
      }
      if (response.success == false && response.result.message) {
        this.form.errorMessage = response.result.message;
      }
      if (response.success == false && response.result.inputerror) {
        this.form.inputError = response.result.inputerror;
      }
      if (this.fileToUpload != null) {
        this.uploadFile();
      }
    })
  }

  onFileSelect(event: any) {
    this.fileToUpload = event.target.files.item(0);
    console.log('file ====> ', this.fileToUpload);
  }

  uploadFile() {
    let self = this;
    const formData = new FormData();
    formData.append('file', this.fileToUpload);
    return this.httpService.post("http://localhost:8080/User/profilePic/" + this.form.data.id, formData, (response: any) => {
      console.log("imageId = " + response.result.imageId);
      self.form.data.imageId = response.result.imageId;
      self.fileToUpload = null;
    });
  }

}
