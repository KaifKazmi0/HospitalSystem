package com.kaif.hospital;

import com.kaif.hospital.repo.PatientRepository;
import com.kaif.hospital.entity.Patient;
import com.kaif.hospital.service.PatientService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class HospitalSystemApplicationTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void getPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

    }

    @Autowired
    private PatientService service;

    @Test
    void getPatientById(){
        Patient patient = service.getPatientById(1L);
        System.out.println(patient);
    }

    @Test
    void getPatientByName(){
        Patient patient = service.getPatientByName("Aarav Sharma");
        System.out.println(patient);
    }

    @Test
    void getAllPatient(){
        List<Patient> patient = service.getAllPatient();
        for(Patient p: patient){
            System.out.println(p);
        }
    }

    @Test
    void getPatientByBirthDate(){
        List<Patient> patient = service.getPatientByBirthDate(LocalDate.of(1993,1,1));
        for(Patient p: patient){
            System.out.println(p);
        }
    }

}
