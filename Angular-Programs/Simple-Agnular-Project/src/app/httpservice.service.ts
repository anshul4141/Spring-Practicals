import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {

  constructor(private httpClient: HttpClient) { }

  post(endpoint: any, formData: any, callBack: any) {

    this.httpClient.post(endpoint, formData).subscribe((response: any) => {
        callBack(response);
      },
      (error: any) => {
        console.error('Error occurred during POST request:', error);
        callBack(null, error);
      }
    );

  }

  get(endpoint: any, callBack: any) {

  }


}
