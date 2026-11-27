import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {

  constructor(private httpClient: HttpClient, private router: Router) { }


  post(endpoint: any, formData: any, callBack: any) {
    this.httpClient.post(endpoint, formData, { withCredentials: true }).subscribe((response: any) => {
      callBack(response);
    }, (error) => {
      console.log('status fail =======>')
      console.log('post fail', error.status);
      if (error.status == 401) {
        this.router.navigateByUrl('login?errorMessage=your session has been expired')
      }
    })
  }


  get(endpoint: any, callBack: any) {
    this.httpClient.get(endpoint, { withCredentials: true }).subscribe((response: any) => {
      callBack(response);
    }, (error) => {
      console.log('status fail =======>')
      console.log('get fail', error.status)
       if (error.status == 401) {
        this.router.navigateByUrl('login?errorMessage=your session has been expired')
      }
    })
  }


}
