package main.java.com.mrjsoft.hospitals.controller;

import main.java.com.mrjsoft.hospitals.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;
    private static final String URL = "http://localhost:8081/people";

    @Test
    public void testGetPerson() throws Exception {
        //prepare
        //no need to prepare data as data created is by PersonPersonLoader

        //execute
        ResponseEntity<Person> responseEntity = restTemplate.getForEntity(URL + "/1", Person.class);

        //collect data
        int status = responseEntity.getStatusCodeValue();
        Person application = responseEntity.getBody();

        //verify an OK status is returned
        assertEquals("Correct Response Status", HttpStatus.OK.value(), status);

        //verify Person returned
        assertNotNull(application);

        //verify the application name is TrackZilla
        assertEquals("TrackZilla", application.getName());

        //verify the UserManagementService was called to the add the hospital name
        assertEquals("Jane Doe", application.getHospitalName());
    }
}
