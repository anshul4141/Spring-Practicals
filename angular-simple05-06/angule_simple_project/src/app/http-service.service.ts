import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(public httpClient: HttpClient, public router: Router) { }

  post(endpoint: any, formData: any, callback: any) {
    this.httpClient.post(endpoint, formData, { withCredentials: true }).subscribe((response: any) => {
      callback(response); // return response as a collback function parameter
    }, (error: any) => {
      if (error.status === 401) {
        localStorage.clear(); // clear local storage if unauthorized
        this.router.navigateByUrl('/login?errorMsg=your session has been expired please re-login..!'); // redirect to login page if unauthorized
      }
    }
    );
  }

  get(endpoint: any, callback: any) {
    this.httpClient.get(endpoint, { withCredentials: true }).subscribe((response: any) => {
      callback(response); // return response as a collback function parameter
    }, (error: any) => {
      if (error.status === 401) {
        localStorage.clear(); // clear local storage if unauthorized
        this.router.navigateByUrl('/login?errorMsg=your session has been expired please re-login..!'); // redirect to login page if unauthorized
      }
    }
    );
  }

}
