package main.java.com.mrjsoft.hospitals.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.mrjsoft.hospitals.domain.Person;
import main.java.com.mrjsoft.hospitals.repositories.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@BasePathAwareController
public class PersonController {
    private final PersonRepository personRepository;
    private Logger log = Logger.getLogger(PersonController.class);

    @Autowired
    public PersonController(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(path = "persons", method = RequestMethod.GET, produces = "application/hal+json")
    public @ResponseBody
    ResponseEntity<?> getPeople() {

        List<Person> persons = personRepository.findAll();
        log.info("Person count: " + persons.size());

        persons.forEach(person -> getPersonInfo(person));

        Resources<Person> resources = new Resources<Person>(persons);
        resources.add(linkTo(methodOn(PersonController.class).getPeople()).withSelfRel());

        return ResponseEntity.ok(resources);
    }

    @RequestMapping(path = "person/{id}", method = RequestMethod.GET, produces = "application/hal+json")
    public @ResponseBody
    ResponseEntity<?> getPerson(@PathVariable Integer id) {
        Person application = personRepository.findOne(id);
        getPersonInfo(application);

        Resource resource = new Resource(application);
        resource.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());

        return ResponseEntity.ok(resource);
    }

    private void getPersonInfo(Person person) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String userManagementService = "http://localhost:8082/hospitals/" + person.getHospitalId();
            ResponseEntity<String> response = restTemplate.getForEntity(userManagementService, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = null;
            root = mapper.readTree(response.getBody());
            JsonNode name = root.path("name");
            JsonNode ein = root.path("ein");
            person.setHospitalName(name.asText());
            person.setHospitalEin(ein.asText());
        } catch (IOException e) {
            person.setHospitalEin("Undefined");
            person.setHospitalName("Undefined");
            e.printStackTrace();
        }

    }

}
