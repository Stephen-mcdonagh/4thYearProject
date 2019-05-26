import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../../services/application.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public applications;

  constructor(private applicationService: ApplicationService) { }

  ngOnInit() {
    this.getApplications();
  }

  getApplications(){
    this.applicationService.getApplications().subscribe(
      data => { this.applications = data},
      err => console.error(err),
      () => console.log('applications loaded')
    );
  }
}
