import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../../services/application.service';
import { Observable } from 'rxjs'
import { ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css']
})
export class ViewRegistrationComponent implements OnInit {

  public applicationReg;

  constructor(private applicationService: ApplicationService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getApplicationReg(this.route.snapshot.params.id);
  }

  getApplicationReg(id:number){
    this.applicationService.getApplication(id)
    .subscribe(
      data =>{
        this.applicationReg =data;
        console.log(this.applicationReg);
      },
      err => console.error(err),
      () => console.log('application loaded')
    );
  }


}
