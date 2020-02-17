package main.java.com.mrjsoft.hospitals.repositories;

import main.java.com.mrjsoft.hospitals.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonManagementRepositoryTests {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String URL = "http://localhost:8081/people";

    @Test
    public void testCreatePerson() throws Exception {
        // prepare
        Person person = new Person("New Person", 12345, "DF", 2);

        //Execute
        ResponseEntity<Person> responseEntity = restTemplate.postForEntity(URL, person, Person.class);

        //collect data
        int status = responseEntity.getStatusCodeValue();
        Person resultPerson = responseEntity.getBody();

        //verify create status
        assertEquals("Correct Response Status", HttpStatus.CREATED.value(), status);
        assertNotNull(resultPerson);

    }

    @Test
    public void testDeletePerson() throws Exception {
        //prepare
        //no need to prepare data as data created is by PersonPersonLoader

        //execute
        ResponseEntity<Void> responseEntity = restTemplate.exchange(URL + "/1", HttpMethod.DELETE,
                null,
                Void.class);

        // collect data
        int status = responseEntity.getStatusCodeValue();

        // verify
        assertEquals(HttpStatus.NO_CONTENT.value(), status);
    }

    @Test
    public void testUpdatePerson() throws Exception {
        //prepare
        // create the application object with id equal to the one to update
        Person person = new Person(1,"New Name", 2);

        HttpEntity<Person> requestEntity = new HttpEntity<>(person);

        //execute
        ResponseEntity<Person> responseEntity = restTemplate.exchange(URL +"/" + person.getId(), HttpMethod.PUT,requestEntity, Person.class);

        //collect data
        int status = responseEntity.getStatusCodeValue();
        Person resultPerson = responseEntity.getBody();

        //verify
        assertEquals(HttpStatus.OK.value(), status);

        //verify the application name is New Name
        assertEquals("New Name", resultPerson.getName());
    }

}
