package com.passport.Application;

import com.passport.Application.controllers.FacialDetectionController;
import com.passport.Application.models.Face;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class RestControllerUnitTest extends Abstract{

    @Autowired
    FacialDetectionController facialDetectionController;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //Unit Test to check we get correct response for all applications.
    @Test
    public void getValidResponse() throws Exception {
        String uri = "/api/v1/applications";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    //Unit Test to check we get correct response for single application within dataabase
    @Test
    public void getValidResponseForSingleApplicationsInDatabase() throws Exception {
        String uri = "/api/v1/applications/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Testing Application model
    @Test
    public void shouldReturnCreatedApplication() throws Exception {
        com.passport.Application.models.Application application = new com.passport.Application.models.Application();
        application.setName("TestName");
        application.setPpsNumber("8190919M");
        application.setNumber("087123456");
        application.setEmail("testemail@dcu.ie");
        application.setDob(Date.valueOf("1990-10-10"));
        application.setId(1001001);
        application.setApplicationDate(Date.valueOf("2019-10-10"));

        Assert.assertEquals(application.getName(),"TestName");
        Assert.assertEquals(application.getEmail(),"testemail@dcu.ie");
        Assert.assertEquals(application.getApplicationDate(),Date.valueOf("2019-10-10"));
        Assert.assertEquals(application.getId(),1001001);
        Assert.assertEquals(application.getDob(),Date.valueOf("1990-10-10"));
        Assert.assertEquals(application.getNumber(),"087123456");

    }

    //Positive test for isValidImageMethod
    //Images must of of type jpg for facial detection
    @Test
    public void PositiveIsValidImage() throws Exception{
        FacialDetectionController controller = new FacialDetectionController();

        Path path = Paths.get("resources\\Positive.jpg");
        String name = "Positive.jpg";
        String originalFileName = "file";
        String contentType = "image/jpeg";
        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
        }
        MultipartFile file = new MockMultipartFile(name,
                originalFileName, contentType, content);

        boolean result;
        result = controller.isValidImage(file);
        Assert.assertEquals(result,true);
    }
    //Negative isValidImage test
    //Below tests with PNG image, checks that the response is false
    @Test
    public void NegativeIsValidImage() throws Exception{
        FacialDetectionController controller = new FacialDetectionController();

        //
        Path path = Paths.get("resources\\Negative.PNG");
        String name = "Negative.PNG";
        String originalFileName = "file";
        String contentType = "image/PNG";
        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
        }
        MultipartFile file = new MockMultipartFile(name,
                originalFileName, contentType, content);

        boolean result;
        result = controller.isValidImage(file);
        Assert.assertEquals(result,false);
    }

    //Test for face model
    @Test
    public void FaceTest(){
        int xC0ordinate = 1;
        int yCoordinate= 1;
        int width= 1;
        int height= 1;
        double ratio=1.0;

        int newX = 2;

        Face face = new Face(xC0ordinate,yCoordinate,width,height,ratio);
        List<Face> faces = new ArrayList<>();
        faces.add(face);
        Assert.assertTrue(faces.isEmpty()==false);

        face.setX(newX);
        face.setY(newX);
        face.setHeight(newX);
        face.setWidth(newX);
        face.setRatio(newX);

        faces.add(face);

        Assert.assertEquals(faces.get(1).getX(),2);
        Assert.assertEquals(faces.get(1).getY(),2);
        Assert.assertEquals(faces.get(1).getHeight(),2);
        Assert.assertEquals(faces.get(1).getWidth(),2);
        Assert.assertEquals(faces.get(1).getRatio(),2.0,0);
    }
}
