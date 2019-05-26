package com.passport.Application;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.passport.Application.controllers.ApplicationsController;
import com.passport.Application.models.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationsController.class)
public class PostRequestTest {

    @MockBean
    ApplicationsController applicationsController;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    //Testing REST Post request with application
    //returns 200 response if working
    @Test
    public void postRequestTest() throws Exception {
        Application application = new Application();
        application.setName("TestName");
        application.setPpsNumber("8190919M");
        application.setNumber("087123456");
        application.setEmail("testemail@dcu.ie");
        application.setDob(Date.valueOf("1990-10-10"));
        application.setId(1001001);
        application.setApplicationDate(Date.valueOf("2019-10-10"));

        MvcResult mvcResult = mockMvc.perform(post("/api/v1/applications")
                .content(mapper.writeValueAsString(application))
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        int status = mvcResult.getResponse().getStatus();

        assertEquals(200, status);
    }
}
