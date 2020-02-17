package main.java.com.mrjsoft.hospitals.domain;

import javax.persistence.*;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hospital_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address;

    // cnpj in Brazil
    @Column(nullable = false)
    private String ein;

    public Hospital() { }

    public Hospital(String name, String ein, Address address) {
        this.name = name;
        this.ein = ein;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEin() { return ein; }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }
}