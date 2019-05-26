package com.passport.Application.Services;

import com.passport.Application.models.Face;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaceDetectionService {

    private List<Face> faces;
    private Mat faceImage;

    public boolean detectFace(MultipartFile file) throws IOException {

        //Create an arraylist of faces detected
        faces = new ArrayList<>();

        MatOfRect faceDetections = new MatOfRect();
        CascadeClassifier faceDetector = new CascadeClassifier();
        //Cascade classifier being loaded locally
        faceDetector.load("C:\\Users\\mcdons59\\DCU\\4thYearProject-CA400\\2019-ca400-mcdons59\\src\\ApplicationSystem\\src\\main\\resources\\LBPCascade\\lbpcascade_frontalface.xml");

        faceImage = Imgcodecs.imdecode(new MatOfByte(file.getBytes()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
        faceDetector.detectMultiScale(faceImage, faceDetections); //used for objects in general- will detect faces as we loaded in our classifier

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        //Draws rectangle around faces: Not seen by user.
        for (Rect rect : faceDetections.toArray()) {
            faces.add(new Face(rect.x, rect.y, rect.width, rect.height, 0));
        }

        //Checking if number of faces detected = 1
        if (faceDetections.toArray().length == 1) {
            return true;
        } else {
            return false;
        }
    }
}
