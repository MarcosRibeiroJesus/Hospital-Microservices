package main.java.com.mrjsoft.hospitals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("main.java.com.mrjsoft")
public class PersonManagementApplication {

	public static void main(String... args) {
		SpringApplication.run(PersonManagementApplication.class, args);

	}
}
