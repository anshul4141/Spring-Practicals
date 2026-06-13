import { Component } from '@angular/core';
import { HttpServiceService } from '../http-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  constructor(private httpService: HttpServiceService) { }
  
    endpoint: any = 'http://localhost:8080/User/save'
  
    form: any = {
      data: {},
      successMessage: '',
      errorMessage: '',
      inputError: {},
    }

    reset(){
      location.reload();
    }
  
    save() {
      console.log('form data ====> ', this.form.data)
      this.httpService.post(this.endpoint, this.form.data, (response: any) => {
        console.log('response ===> ', response)
        if (response.success == true && response.result.message) {
          this.form.successMessage = response.result.message;
        }
        if (response.success == false && response.result.message) {
          this.form.errorMessage = response.result.message;
        }
        if (response.success == false && response.result.inputerror) {
          this.form.inputError = response.result.inputerror;
        }
      })
    }

}
