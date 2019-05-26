import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor(private http:HttpClient) { }

  getApplications(){
    return this.http.get('server/api/v1/applications');
  }

  getApplication(id: number){
    return this.http.get('/server/api/v1/applications/' + id)
  }

  createApplication(application){
    let body = JSON.stringify(application);
    return this.http.post('/server/api/v1/applications', body, httpOptions);
  }

}
