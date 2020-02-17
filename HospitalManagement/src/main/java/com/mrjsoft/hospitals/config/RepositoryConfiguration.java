package main.java.com.mrjsoft.hospitals.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"main.java.com.mrjsoft.hospitals.domain"})
@EnableJpaRepositories(basePackages = {"main.java.com.mrjsoft.hospitals.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
