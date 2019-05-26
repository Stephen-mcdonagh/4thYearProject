import { Component, OnInit } from '@angular/core';
import { ApplicationService } from '../../services/application.service';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import {Observable} from 'rxjs';
import {EmailServiceService} from '../../services/email-service.service';
import {FacialDetectionService} from '../../services/facial-detection.service';
import { FileUploadModule } from 'ng2-file-upload';
import { FileUploader } from 'ng2-file-upload';
import {WebcamModule} from 'ngx-webcam';


import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

public email;
public imageResponse;
public myResponse;

public imageUploaded = false;

applicationForm: FormGroup;
validMessage: string = "";
imageMessage: string = "";
fileToUpload: File = null;

notValid =false;



// let isDone: boolean = false;


  constructor(private http:HttpClient, private applicationService: ApplicationService, private emailServiceService: EmailServiceService, private FacialDetectionService: FacialDetectionService) { }

  ngOnInit() {

  this.applicationForm = new FormGroup({
    name: new FormControl('',[Validators.required,Validators.minLength(4)]),
    dob: new FormControl('',Validators.required),
    email: new FormControl('',Validators.required),
    number: new FormControl('',Validators.required),
    ppsNumber: new FormControl('',Validators.required),
    image: new FormControl('',Validators.required)

    //applicationDate: new FormControl('',Validators.required),
    });
  }

  //This is the code to upload file(video)

fileUploaded: File = null;




  async OnFileSelected(event){
    this.fileUploaded = <File>event.target.files[0];
    const fd = new FormData();
    fd.append('file', this.fileUploaded);
    this.http.post('server/api/v1/detect-face', fd)
    .subscribe(
      data => {
        this.imageResponse = JSON.stringify(data);
        if(this.imageResponse == "true"){
          this.imageMessage ="Your Image Has been accepted";
        }
        else{
          this.imageMessage ="Please Enter A new Image";
        }
      },
      err => console.error(err)
    );
  }
  /////////////////////////////////////////////////

//   getResponseForFacialDetection(){
//   console.log(this.imageResponse);
//   this.FacialDetectionService.getFacialDetectionResponse().subscribe(
//     data => { this.imageResponse = data},
//     err => console.error(err),
//     () => console.log(this.imageResponse)
//     // () => console.log('Image Response received')
//   );
//   if(this.imageResponse == true){
//     //console.log('image accepted');
//     this.imageMessage = "Your Image has been accepted";
//   }else{
//     //console.log(this.imageResponse);
//     this.imageMessage = "Please enter a new image";
//   }
// }

  //Handles post request FormData
  //Email verification sent
  submitRegistration(){
    if(this.applicationForm.valid){
      this.validMessage = "Your passport application has been submitted. Please check your email. Thank You.";
      //this.EmailServiceService.sendEmail();
      this.emailServiceService.sendEmail().subscribe(
        data => { this.email = data},
        err => console.error(err),
        () => console.log('email Sent')
      );
      this.applicationService.createApplication(this.applicationForm.value).subscribe(
        data => {
          this.applicationForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      )
    } else {
      this.notValid = true;
      this.validMessage = "Please complete application before submitting";
    }
  }


}
