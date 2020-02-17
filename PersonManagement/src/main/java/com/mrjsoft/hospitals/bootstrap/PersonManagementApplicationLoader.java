package main.java.com.mrjsoft.hospitals.bootstrap;

import main.java.com.mrjsoft.hospitals.domain.Person;
import main.java.com.mrjsoft.hospitals.repositories.PersonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class PersonManagementApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PersonRepository personRepository;
    private Logger log = Logger.getLogger(PersonManagementApplicationLoader.class);

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Person person1 = new Person("Martha", 00010, "DF", 5);
        Person person2 = new Person("Mariana", 00011, "DF", 1);
        Person person3 = new Person("Mara", 00012, "DF", 2);
        Person person4 = new Person("Celina",00013, "DF", 3);
        Person person5 = new Person("Cecília", 00014, "DF", 4);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);
    }

}
