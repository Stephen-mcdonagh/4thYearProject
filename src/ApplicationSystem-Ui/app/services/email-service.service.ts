import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class EmailServiceService {

  constructor(private http:HttpClient) { }

  sendEmail(){
    return this.http.get('server/api/v1/email');
  }
}
