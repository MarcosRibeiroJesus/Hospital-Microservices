package main.java.com.mrjsoft.hospitals.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="person_id")
    private Integer id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer coren;

    @Column(nullable=false)
    private String corenOriginState;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate birthDate;

    @Column(nullable = false)
    private Integer hospitalId;

    @Transient
    private String hospitalName;

    // CNPJ in Brazil
    @Transient
    private String hospitalEin;

    public Person() {}

    public Person(
            String name,
            Integer coren,
            String corenOriginState,
            Integer hospitalId) {
        this.name = name;
        this.coren = coren;
        this.corenOriginState = corenOriginState;
        this.hospitalId = hospitalId;
    }

    //for unit/integration tests only
    public Person(Integer id, String name, Integer hospitalId) {
        this.id = id;
        this.name = name;
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.hospitalEin = hospitalEin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoren() { return coren; }

    public void setCoren(Integer coren) { this.coren = coren; }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalEin() {
        return hospitalEin;
    }

    public void setHospitalEin(String hospitalEin) {
        this.hospitalEin = hospitalEin;
    }

    public String getCorenOriginState() {
        return corenOriginState;
    }

    public void setCorenOriginState(String corenOriginState) {
        this.corenOriginState = corenOriginState;
    }

}
