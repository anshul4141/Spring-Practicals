import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  constructor(private httpClient: HttpClient) { }

  post(endpoint: any, formData: any, callBack: any) {
    this.httpClient.post(endpoint, formData).subscribe((response) => {
      callBack(response);
    });
  }

  get(endpoint: any, callBack: any) {
    this.httpClient.get(endpoint).subscribe((response) => {
      callBack(response);
    });
  }

}
