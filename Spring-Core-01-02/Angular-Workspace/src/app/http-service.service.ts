import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient, private router: Router) { }

  post(endpoint: any, formData: any, callBack: any) {
    this.httpClient.post(endpoint, formData, { withCredentials: true }).subscribe((response) => {
      callBack(response);
    }, (error) => {
      if (error.status == 401) {
        this.router.navigateByUrl('/login?errorMsg=Session Expired. Please login again');
      }
    })
  }

  get(endpoint: any, callBack: any) {
    this.httpClient.get(endpoint, { withCredentials: true }).subscribe((response) => {
      callBack(response);
    }, (error) => {
      if (error.status == 401) {
        this.router.navigateByUrl('/login?errorMsg=Session Expired. Please login again');
      }
    })
  }

}
