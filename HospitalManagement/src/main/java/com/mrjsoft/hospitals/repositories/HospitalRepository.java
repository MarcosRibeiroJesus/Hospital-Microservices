package main.java.com.mrjsoft.hospitals.repositories;

import main.java.com.mrjsoft.hospitals.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
