package com.passport.Application.controllers;


import com.passport.Application.Services.FaceDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FacialDetectionController {

    @Autowired
    FaceDetectionService faceDetectionService;

    //Returns true if One face is detected
    //Requesting multipart file
    @PostMapping("api/v1/detect-face")
    @ResponseBody
    public boolean detectFaceImage(@RequestParam("file") MultipartFile file) {
        try{
            if(isValidImage(file)){
                System.out.println("CORRECT IMAGE TYPE");
                System.out.println("Successfully Uploaded: "+ file.getOriginalFilename());

                return faceDetectionService.detectFace(file);
            }
            else{
                System.out.println("ERROR");
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    //Check for correct image type- Must be of type JPG
    public Boolean isValidImage(MultipartFile image) {
        if(image.getContentType().equals("image/jpeg")){
            return true;
        }
        else{
            return false;
        }
    }
}

