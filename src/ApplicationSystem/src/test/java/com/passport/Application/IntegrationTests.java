package com.passport.Application;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    //Testing Get request for springboot with my Sqlite DB
    @Test
    public void testRetrieveApplication() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("api/v1/applications/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":1,\"name\":\"Stephen Mcdonagh\",\"dob\":\"01-20-2110\",\"email\":\"stephen1@gmail.com\",\"number\":\"0871234567\",\"ppsNumber\":\"0912345M\",\"applicationDate\":\"01-20-2110\"}\n";

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }

    //Method to create port to run tests on. Port is random
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
