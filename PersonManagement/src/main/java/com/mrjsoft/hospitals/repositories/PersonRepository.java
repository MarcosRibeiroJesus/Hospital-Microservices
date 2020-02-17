package main.java.com.mrjsoft.hospitals.repositories;

import main.java.com.mrjsoft.hospitals.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
