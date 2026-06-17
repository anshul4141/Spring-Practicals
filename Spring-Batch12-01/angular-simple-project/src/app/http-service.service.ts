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
      this.handleError(error);
    });
  }

  get(endpoint: any, callBack: any) {
    this.httpClient.get(endpoint, { withCredentials: true }).subscribe((response) => {
      callBack(response);
    }, (error) => {
      this.handleError(error);
    });
  }

  handleError(error: any) {
    if (error.status == 401) {
      localStorage.clear();
      this.router.navigateByUrl(
        '/login?errorMessage=session expired, please login again'
      );
    }
  }

}
