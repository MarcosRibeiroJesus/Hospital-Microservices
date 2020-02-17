package main.java.com.mrjsoft.hospitals.bootstrap;

import main.java.com.mrjsoft.hospitals.domain.Address;
import main.java.com.mrjsoft.hospitals.domain.Hospital;
import main.java.com.mrjsoft.hospitals.repositories.HospitalRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class HospitalManagementApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {


    private HospitalRepository hospitalRepository;
    private Logger log = Logger.getLogger(HospitalManagementApplicationLoader.class);

    @Autowired
    public void setApplicationRepository(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Hospital hospital1 = new Hospital("HRP", "02.073.014/0001-60",
                new Address("Q 2", "2", "", "Paranoá",
                        "", "Paranoá", "DF"));
        Hospital hospital2 = new Hospital("HRSM", "37.295.427/0001-74",
                new Address(" CL 102 - Santa Maria, Brasília ", "102", "", "Santa Maria Sul",
                        "72502-100", "Santa Maria", "DF"));
        Hospital hospital3 = new Hospital("Policlínica Mais", "78.479.573/0001-37",
                new Address("Quadra 01 - Conjunto A - Casa 05", "5", "", "Setor Sul",
                        "72410-101", "Gama", "DF"));
        Hospital hospital4 = new Hospital("Sabin", "69.875.636/0001-83",
                new Address("516 Norte, Edifício Carlton Center, Bloco E, Loja 74, Térreo", "74", "", "Asa Norte",
                        "", "Brasília", "DF"));
        Hospital hospital5 = new Hospital("Hospital Daher Sul", "16.384.442/0001-19",
                new Address("SHIS, QI 7, Conj. F - Lago Sul, Brasília", "7", "", "Lago Sul",
                        "71615-660", "Brasília", "DF"));
        hospitalRepository.save(hospital1);
        hospitalRepository.save(hospital2);
        hospitalRepository.save(hospital3);
        hospitalRepository.save(hospital4);
        hospitalRepository.save(hospital5);
    }
}
