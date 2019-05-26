import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class FacialDetectionService {

  constructor(private http:HttpClient) { }

  getFacialDetectionResponse(){
    return this.http.get('server/api/v1/detect-face');
  }


}
