package com.passport.Application;

import com.passport.Application.controllers.EmailController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class EmailTests extends Abstract{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //Unit Test to check we get correct response for sending email
    @Test
    public void getValidResponseForEmailBeingSent() throws Exception {
        String uri = "/api/v1/email";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Testing randomness
    @Test
    public void randomNumberOrderTest() throws Exception{
        int x = EmailController.generateRandomOrderNumber();
        int y = EmailController.generateRandomOrderNumber();

        Assert.assertNotEquals(x,y);

    }
}
